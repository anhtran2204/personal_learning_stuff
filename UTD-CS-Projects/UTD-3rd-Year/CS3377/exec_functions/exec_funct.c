#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <fcntl.h>
#include <unistd.h>

int main() {
    DIR *dir_stream;
    int fd;
    struct dirent *dir_entry;

    // Open the root directory using opendir
    dir_stream = opendir("/");
    if (dir_stream == NULL) {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    // Peek at the implementation of the DIR structure and print close-on-exec flag
    printf("Directory stream close-on-exec flag after opendir: ");
    fd = dirfd(dir_stream);
    if (fd == -1) {
        perror("dirfd");
        exit(EXIT_FAILURE);
    }

    int flags = fcntl(fd, F_GETFD);
    if (flags == -1) {
        perror("fcntl");
        exit(EXIT_FAILURE);
    }
    printf("%s\n", (flags & FD_CLOEXEC) ? "FD_CLOEXEC is set" : "FD_CLOEXEC is not set");

    // Close the directory stream
    closedir(dir_stream);

    // Open the same directory for reading
    fd = open("/", O_RDONLY | O_DIRECTORY);
    if (fd == -1) {
        perror("open");
        exit(EXIT_FAILURE);
    }

    // Peek at the close-on-exec flag for the file descriptor
    printf("File descriptor close-on-exec flag after open: ");
    flags = fcntl(fd, F_GETFD);
    if (flags == -1) {
        perror("fcntl");
        exit(EXIT_FAILURE);
    }
    printf("%s\n", (flags & FD_CLOEXEC) ? "FD_CLOEXEC is set" : "FD_CLOEXEC is not set");

    // Close the file descriptor
    close(fd);

    return 0;
}

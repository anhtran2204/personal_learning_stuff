#include <stdio.h>
#include <sys/socket.h>
#include <sys/stat.h>
#include "apue.h"

int main() {
    struct stat stat = {};
    const int fd = socket(AF_INET, SOCK_STREAM, 0);

    if(fd < 0) {
        err_sys("socket error");
    }

    if (fstat(fd, &stat) < 0) {
        err_sys("fstat error");
    }

    printf("st_mode:        %u\n", stat.st_mode);
    printf("st_ino:         %lu\n", stat.st_ino);
    printf("st_dev:         %lu\n", stat.st_dev);
    printf("st_rdev:        %lu\n", stat.st_rdev);
    printf("st_nlink:       %lu\n", stat.st_nlink);
    printf("st_uid:         %u\n", stat.st_uid);
    printf("st_gid:         %u\n", stat.st_gid);
    printf("st_size:        %lu\n", stat.st_size);
    printf("st_atim:        %lu\n", stat.st_atim);
    printf("st_mtim:        %lu\n", stat.st_mtim);
    printf("st_ctim:        %lu\n", stat.st_ctim);
    printf("st_blksize:     %lu\n", stat.st_blksize);
    printf("st_blocks:      %lu\n", stat.st_blocks);

    return 0;
}

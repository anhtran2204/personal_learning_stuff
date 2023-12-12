#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int fd[2]; // File descriptors for the pipe
    pid_t pid1, pid2;

    // Create a pipe
    if (pipe(fd) == -1) {
        perror("Pipe failed");
        return 1;
    }

    // Create the first child process
    pid1 = fork();

    if (pid1 < 0) {
        perror("Fork failed");
        return 1;
    } else if (pid1 == 0) { // Child process 1
        close(fd[0]); // Close the reading end of the pipe

        // Send data to the second child
        char message1[] = "Hello from Child 1!";
        write(fd[1], message1, sizeof(message1));
        close(fd[1]); // Close the writing end of the pipe
    } else { // Parent process
        // Create the second child process
        pid2 = fork();

        if (pid2 < 0) {
            perror("Fork failed");
            return 1;
        } else if (pid2 == 0) { // Child process 2
            close(fd[1]); // Close the writing end of the pipe

            // Receive data from the first child
            char message2[100];
            read(fd[0], message2, sizeof(message2));
            printf("Child 2 received: %s\n", message2);
            close(fd[0]); // Close the reading end of the pipe
        } else { // Parent process
            // Wait for both child processes to complete
            wait(NULL);
            wait(NULL);
        }
    }

    return 0;
}

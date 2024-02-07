#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int
main()
{
    int pipefd[2];
    pid_t cpid;
    int buf = 110;
    int arr[] = {1, 2, 3, 4};

    if (pipe(pipefd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    cpid = fork();
    if (cpid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (cpid == 0) {    //Child process
        close(pipefd[0]);
//        for (int i = 0; i < 4; ++i) {
            write(pipefd[1], &buf, sizeof(buf));
//        }
        close(pipefd[1]);
        exit(0);
    }
    else {  //Parent process
        close(pipefd[1]);
        ssize_t rc;
//        buf = 0;
//        while ((rc = read(pipefd[0], &buf, sizeof(int))) > 0) {
            read(pipefd[0], &buf, sizeof(int));
            printf("PARENT: read \"%d\"\n", buf);
//        }
//        waitpid(-1, NULL, 0);
    }
}
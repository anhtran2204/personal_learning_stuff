#include <stdio.h>
#include <unistd.h>

void child_func() {
    printf("Child process\n");
    printf("Child: Returning from child_func\n");
    return;
}

void parent_func() {
    printf("Parent process\n");
    printf("Parent: Calling vfork\n");

    pid_t child_pid = vfork();

    if (child_pid == 0) {
        printf("Child: My PID is %d\n", getpid());
        child_func();
        printf("Child: Exiting\n");
        _exit(0);
    } else if (child_pid > 0) {
        printf("Parent: My PID is %d\n", getpid());
        printf("Parent: Child PID is %d\n", child_pid);
    } else {
        perror("vfork");
    }

    printf("Parent: Returning from parent_func\n");
    return;
}

int main() {
    printf("Main process\n");
    printf("Main: My PID is %d\n", getpid());
    printf("Main: Calling parent_func\n");

    parent_func();

    printf("Main: Exiting\n");
    return 0;
}

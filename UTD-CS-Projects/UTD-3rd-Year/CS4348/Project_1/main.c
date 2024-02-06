#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <ctype.h>
#include <errno.h>
#include <string.h>

#define PERROR(FMT,...) \
  fprintf(stderr, FMT ": %s\n", ##__VA_ARGS__, strerror(errno))

int main(int argc, char *argv[]) {
    int arr[100];
    FILE *fptr = fopen("sample0.txt", "r");

    if (fptr == NULL) {
        PERROR("The file %s could not be opened", argv[1]);
        exit( EXIT_FAILURE );
    }

    printf("File open successfully!\n");

    char buf[1000];
    while (fgets(buf, sizeof(buf), fptr) != NULL) {
        printf("%d\n", atoi(buf));
    }

//    int memory[2000];
//    int PC, SP, IR, AC, X, Y;
//    int instructions;
//
//    FILE *fptr;
//    fptr = fopen("sample1.txt", "r");
//
//    if (fptr == NULL) {
//        printf("Error: File doesn't exist!");
//        exit(0);
//    }
//
//    int count = 0;
//    int data;
//    int ch;
//    while ((ch = fgetc(fptr)) != EOF) {
//        if (isdigit(ch)) {
//            printf("%d\n", ch);
//            data = ch - '0';
//            memory[count] = data;
//        }
//        count++;
//    }
//
//    int result = fork();
//    if (result == 0) {
//        // child process
//
//    } else {
//        // parent process
//        switch (instructions) {
//            case 1:         // Load value into AC
//                break;
//
//            case 2:
//                break;
//
//            case 3:
//                break;
//
//            case 4:
//                break;
//
//            case 5:
//                break;
//
//            case 6:
//                break;
//
//            case 7:
//                break;
//
//            case 8:
//                break;
//
//            case 9:
//                break;
//
//            case 10:
//                break;
//
//            case 11:
//                break;
//
//            case 12:
//                break;
//
//            case 13:
//                break;
//
//            case 14:
//                break;
//
//            case 15:
//                break;
//
//            case 16:
//                break;
//
//            case 17:
//                break;
//
//            case 18:
//                break;
//
//            case 19:
//                break;
//
//            case 20:
//                break;
//
//            case 21:
//                break;
//
//            case 22:
//                break;
//
//            case 23:
//                break;
//
//            case 24:
//                break;
//
//            case 25:
//                break;
//
//            case 26:
//                break;
//
//            case 27:
//                break;
//
//            case 28:
//                break;
//
//            case 29:
//                break;
//
//            case 30:
//                break;
//
//            case 50:
//                break;
//        }
//    }
    return 0;
}

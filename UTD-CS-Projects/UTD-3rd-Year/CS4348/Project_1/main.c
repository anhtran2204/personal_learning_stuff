#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <ctype.h>

#define SIZE 100

int main(int argc, char *argv[]) {
    int memory[2000];
    int PC, SP, IR, AC, X, Y;
    int instructions;

    FILE *fptr;
    fptr = fopen("sample1.txt", "w");

    if (fptr == NULL) {
        printf("Error: File doesn't exist!");
        exit(0);
    }

    int count = 0;
    int data;
    char ch;
    while (ch != EOF) {
        ch = fgetc(fptr);
        printf(ch);
        if (isdigit(ch)) {
            printf("integer\n");
            data = ch - '0';
            memory[count] = data;
            printf("%d", data);
        }
        count++;
    }

    int result = fork();
    if (result == 0) {
        // child process
        
    } else {
        // parent process
        switch (instructions) {
            case 1:         // Load value into AC
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            case 8:
                break;

            case 9:
                break;

            case 10:
                break;

            case 11:
                break;

            case 12:
                break;

            case 13:
                break;

            case 14:
                break;

            case 15:
                break;

            case 16:
                break;

            case 17:
                break;

            case 18:
                break;

            case 19:
                break;

            case 20:
                break;

            case 21:
                break;

            case 22:
                break;

            case 23:
                break;

            case 24:
                break;

            case 25:
                break;

            case 26:
                break;

            case 27:
                break;

            case 28:
                break;

            case 29:
                break;

            case 30:
                break;

            case 50:
                break;
        }
    }
    return 0;
}

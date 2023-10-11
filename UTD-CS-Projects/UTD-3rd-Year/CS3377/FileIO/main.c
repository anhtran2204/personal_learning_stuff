#include <stdio.h>
#include <stdlib.h>

int main() {
    printf("Type your full name and GPA: ");
    char name[100];
    float gpa;
    fgets(name, sizeof(name), stdin);
    scanf("%f", &gpa);

    FILE *fptr;
    fptr = fopen("file.txt","w");

    if (fptr == NULL) {
        printf("Error! File not exist!");
        exit(1);
    }

    fprintf(fptr, "%s", name);
    fprintf(fptr, "%f", gpa);

    return 0;
}

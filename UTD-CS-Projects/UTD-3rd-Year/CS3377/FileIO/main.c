#include <stdio.h>
#include <stdlib.h>

int main() {
    printf("Type your full name and GPA: \n");
    char name[100];
    double gpa;
    fgets(name, sizeof(name), stdin);
    scanf("%lf", &gpa);

    FILE *fptr;
    fptr = fopen("file.txt", "w");

    if (fptr == NULL) {
        printf("Error! File not exist!");
        exit(1);
    }

    fprintf(fptr, "%s", name);
    fprintf(fptr, "%f", gpa);
    fclose(fptr);

    if ((fptr = fopen("file.txt", "r")) == NULL) {
        printf("Error! Unable to open file!");
        exit(1);
    }

    char firstNameOut[20];
    char lastNameOut[20];
    double gpaOut = 0.0;
    fscanf(fptr, "%s %s %lf", firstNameOut, lastNameOut, &gpaOut);
    printf("Name: %s %s, GPA: %.2lf\n", firstNameOut, lastNameOut, gpaOut);
    fclose(fptr);

    return 0;
}

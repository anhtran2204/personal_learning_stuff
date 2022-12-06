#include "stdio.h"
#include "stdbool.h"
#include "string.h"
#include "ctype.h"

void getName();
void getPassword();

int main() {
    printf("1 - name function\n");
    printf("2 - password function\n");
    
    int input;
    scanf("%d", &input);
    
    if (input == 1)
        getName();
    else if (input == 2)
        getPassword();

    return 0;
}

void getName() {
    char firstName[21], middleName[21], lastName[21];
    scanf("%s %s %s", firstName, middleName, lastName);
    
    char name[64];
    strncpy(name, lastName, 20);
    strcat(name, ", ");
    strncat(name, firstName, 20);
    strcat(name, " ");
    strncat(name, middleName, 20);
    
    printf("%s", name);
}

void getPassword() {
    char password[15];
    scanf("%s", password);
    
    int passwordLength = (int)strlen(password);
    bool containsLowercase = false;
    bool containsUppercase = false;
    bool containsDigit = false;
    bool containsPunctuation = false;
    
    for (int i = 0; i <= passwordLength - 1; i++) {
        if (islower(password[i]) != 0)
            containsLowercase = true;
        if (isupper(password[i]) != 0)
            containsUppercase = true;
        if (isdigit(password[i]) != 0)
            containsDigit = true;
        if (isalnum(password[i]) == 0)
            containsPunctuation = true;
    }
    
    if (passwordLength < 6)
        printf("Password too short\n");
    if (passwordLength > 14)
        printf("Password too long\n");
    if (containsLowercase == false)
        printf("Password missing lowercase letter\n");
    if (containsUppercase == false)
        printf("Password missing uppercase letter\n");
    if (containsDigit == false)
        printf("Password missing digit\n");
    if (containsPunctuation == false)
        printf("Password missing punctuation\n");
    
}
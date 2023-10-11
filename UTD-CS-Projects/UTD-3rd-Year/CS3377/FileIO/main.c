#include <stdio.h>

int main() {
    printf("Type your full name: ");
    char name[100];
    fgets(name, sizeof(name), stdin);
    printf("Hello %s", name);

    return 0;
}

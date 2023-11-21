#include <stdio.h>
#include <unistd.h>
#include "apue.h"

int main( )
{
    alarm(1);
    printf("Hello, World!\n");
    return 0;
}

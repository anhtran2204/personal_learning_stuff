#include <stdio.h>

int main()
{
    int i=0;

    setvbuf(stdout, NULL, _IONBF,0);

    printf("%d ",i++);

    return 0;
}
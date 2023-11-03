#include <unistd.h>
#include "stdio.h"
#include "fcntl.h"

char buf[8];

int
main()
{

    int fp;
    int i, off;

// The below section will open a new file and write data to it
// First 4 bytes are changed to differetiate each field
    fp = open("apentest.txt", O_WRONLY | O_CREAT, S_IRUSR | S_IWUSR);

    for (i = 0; i < 5; i ++)
    {
        buf[0] = i + 48; //will print a digit 0,1 ...
        buf[1] = i + 64; // will print capital letter A, B ...
        buf[2] = i + 96; //will print smallcase letter from a, b ...

        write(fp, buf, 8);
    }

    close(fp);

// File is closed and opened again in readwrite with append mode.

    fp = open("apentest.txt", O_RDWR | O_APPEND);

    for (i = 5; i < 7; i ++)
    {
        buf[0] = i + 48; //will print a digit 0,1 ...
        buf[1] = i + 64; // will print capital letter A, B ...
        buf[2] = i + 96; //will print smallcase letter from a, b ...

        write(fp, buf, 8);
    }
//After writing two record now we change the position in the file to end of second record.

//and try to read the record from there.

    off = lseek(fp,16,SEEK_SET);
    read(fp,buf,8);
    printf("Read record content : %c %c %c\n", buf[0], buf[1], buf[2]);
//Successful read changes the position of pointer to the end of record read


// New records are written without chaning the current position in the file.

    for (i = 7; i < 10; i ++)
    {
        buf[0] = i + 48; //will print a digit 0,1 ...
        buf[1] = i + 64; // will print capital letter A, B ...
        buf[2] = i + 96; //will print smallcase letter from a, b ...

        write(fp, buf, 8);
    }
    close(fp);
}
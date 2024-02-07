#include <iostream>
#include <fstream>

#define PERROR(FMT,...) \
  fprintf(stderr, FMT ": %s\n", ##__VA_ARGS__, strerror(errno))

using namespace std;

int main(int argc, char *argv[]) {
    int PC, SP, IR, AC, X, Y;
    int instructions;

    ifstream file;
    file.open(argv[1]);
    
    return 0;
}

#include <iostream>
#include <fstream>
#include <cstring>
#include <unistd.h>
#include <sstream>

#define PERROR(FMT,...) \
  fprintf(stderr, FMT ": %s\n", ##__VA_ARGS__, strerror(errno))

using namespace std;

int main(int argc, char *argv[]) {
    int mem_to_cpu[2];
    int cpu_to_mem[2];
    pid_t pid;
    int PC, SP, IR, AC, X, Y;
    int instructions;

    ifstream file;
    file.open("./sample1.txt");

    if (!file.is_open()) {
        PERROR("The file %s could not be opened", argv[1]);
        exit( EXIT_FAILURE );
    }

    string line;
    while (getline(file, line)) {
        string::size_type n = line.find("//");
        if (n != string::npos) {
            line.erase(n);
        }

        istringstream iss(line);

        double atype;
        while (iss >> atype) {
            cout << atype << endl;
        }
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

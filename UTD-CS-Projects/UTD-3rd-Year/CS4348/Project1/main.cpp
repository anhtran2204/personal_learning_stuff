#include <iostream>
#include <fstream>
#include <cstring>
#include <unistd.h>
#include <sstream>
#include <wait.h>
#include <random>

#define PERROR(FMT,...) \
  fprintf(stderr, FMT ": %s\n", ##__VA_ARGS__, strerror(errno))

using namespace std;

int *load_data(const char *file_name);

int main(int argc, const char *argv[]) {
    int mem_to_cpu[2];
    int cpu_to_mem[2];
    pid_t pid;

    int result1 = pipe(mem_to_cpu);
    int result2 = pipe(cpu_to_mem);

    if (result1 < 0 || result2 < 0) {
        PERROR("pipe() failed");
        exit(1);
    }

    const char *file = "sample0.txt";
    load_data(file);

    int buf[100];
    fflush(0);
    pid = fork();
    if (pid < 0) {
        PERROR("fork() failed!");
        exit(1);
    }
    else if (pid == 0) {
        // Memory process
        int *memory = load_data(file);
        int PC, data, address;

        int count = 0;
        while (true) {
            read(cpu_to_mem[0], &PC, sizeof(PC));
            int instruction = memory[PC];
            write(mem_to_cpu[1], &instruction, sizeof(memory[0]));
        }
    } else {
        // CPU process
        int PC, SP, IR, AC, X, Y;
        int port = 0;
        int operand = 0;

        X = 0;
        Y = 0;
        IR = 0;
        AC = 0;
        SP = 1000;
        PC = 0;
        bool mode = false; // true: kernel mode; false: user mode

        while (true) {
            write(cpu_to_mem[1], &PC, sizeof(PC));
            read(mem_to_cpu[0], &IR, sizeof(IR));
            switch (IR) {
                case 8: {
                    PC++;
                    std::random_device seed;
                    std::mt19937 gen{seed()}; // seed the generator
                    std::uniform_int_distribution<> dist{1, 100}; // set min and max
                    AC = dist(gen);
                    break;
                }

                case 9:
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &port, sizeof(port));
                    if (port == 1) {
                        printf("%i\n", AC);
                    } else if (port == 2) {
                        printf("%c\n", AC);
                    }
                    break;

                case 10:
                    PC++;
                    AC += X;
                    break;

                case 11:
                    PC++;
                    AC += Y;
                    break;

                case 14:
                    PC++;
                    X = AC;
                    break;

                case 16:
                    PC++;
                    Y = AC;
                    break;

                case 50:
                    exit(0);

                default:
                    PC++;
                    break;
            }
        }

//        switch (instructions) {
//            case 1:         // Load value into AC
//                break;
//
//            case 2:
//                break;
//
//            case 3:
//                break;
//
//            case 4:
//                break;
//
//            case 5:
//                break;
//
//            case 6:
//                break;
//
//            case 7:
//                break;
//
//            case 8:
//                break;
//
//            case 9:
//                break;
//
//            case 10:
//                break;
//
//            case 11:
//                break;
//
//            case 12:
//                break;
//
//            case 13:
//                break;
//
//            case 14:
//                break;
//
//            case 15:
//                break;
//
//            case 16:
//                break;
//
//            case 17:
//                break;
//
//            case 18:
//                break;
//
//            case 19:
//                break;
//
//            case 20:
//                break;
//
//            case 21:
//                break;
//
//            case 22:
//                break;
//
//            case 23:
//                break;
//
//            case 24:
//                break;
//
//            case 25:
//                break;
//
//            case 26:
//                break;
//
//            case 27:
//                break;
//
//            case 28:
//                break;
//
//            case 29:
//                break;
//
//            case 30:
//                break;
//
//            case 50:
//                break;
//        }
    }
    
    return 0;
}

int *load_data(const char *file_name) {
    static int memory[2000];
    char buf[1000];
    int line = 0;

    FILE *file;
    file = fopen(file_name, "r");

    if (!file) {
        PERROR("The file %s could not be opened", file_name);
        exit( EXIT_FAILURE );
    }

    while(fgets(buf, sizeof(buf), file) != NULL) {
        if (isdigit((int) buf[0]) || buf[0] == '.') {
            int num;
            if (buf[0] == '.') {
                sscanf(buf, ".%d %*s\n", &num);
                line = num;
                memory[line] = num;
            } else {
                sscanf(buf, "%d %*s\n", &num);
                memory[line] = num;
                line++;
            }
        }
    }
    fclose(file);
    return memory;
}

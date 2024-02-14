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
                case 1:         // Load value: Load value into AC
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;

                case 2:
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;

                case 3: {
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    write(cpu_to_mem[1], &operand, sizeof(operand));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    if (operand >= 1000 && !mode) {
                        PERROR("Error: Unauthorized attempt to access system memory at address \"%d\" in user mode!", operand);
                        exit(1);
                    }
                    write(cpu_to_mem[1], &operand, sizeof(operand));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 4: {
                    PC++;
                    int addrX = PC + X;
                    write(cpu_to_mem[1], &addrX, sizeof(addrX));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 5: {
                    PC++;
                    int addrY = PC + Y;
                    write(cpu_to_mem[1], &addrY, sizeof(addrY));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 6: {
                    PC++;
                    int spX = SP + Y;
                    write(cpu_to_mem[1], &spX, sizeof(spX));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 7: {
                    PC++;

                    break;
                }

                case 8: {
                    PC++;
                    std::random_device seed;
                    std::mt19937 gen{seed()}; // seed the generator
                    std::uniform_int_distribution<> dist{1, 100}; // set min and max
                    AC = dist(gen);
                    break;
                }

                case 9: {
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &port, sizeof(port));
                    if (port == 1) {
                        printf("%i\n", AC);
                    } else if (port == 2) {
                        printf("%c\n", AC);
                    }
                    break;
                }

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

                case 15:
                    PC++;
                    break;

                case 16:
                    PC++;
                    Y = AC;
                    break;
                case 17:
                    PC++;
                    break;

                case 18:
                    PC++;
                    break;

                case 19:
                    PC++;
                    break;

                case 20:
                    PC++;
                    break;

                case 21:
                    PC++;
                    break;

                case 22:
                    PC++;
                    break;

                case 23:
                    PC++;
                    break;

                case 24:
                    PC++;
                    break;

                case 25:
                    PC++;
                    break;

                case 26:
                    PC++;
                    break;

                case 27:
                    PC++;
                    break;

                case 28:
                    PC++;
                    break;

                case 29:
                    PC++;
                    break;

                case 30:
                    PC++;
                    break;

                case 50:
                    exit(0);

                default:
                    break;
            }
        }

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

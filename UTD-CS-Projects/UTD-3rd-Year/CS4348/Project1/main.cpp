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

    string file_name = argv[1];
    int timer = 30;

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

        while (true) {
            read(cpu_to_mem[0], &PC, sizeof(PC));
            if (PC == -1) {
                read(cpu_to_mem[0], &address, sizeof(address));
                read(cpu_to_mem[0], &data, sizeof(data));
                memory[address] = data;
            } else {
                int instruction = memory[PC];
                write(mem_to_cpu[1], &instruction, sizeof(memory[0]));
            }
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
        int write_flag = -1;
        int interrupt_flag = 0;
        bool timer_interrupt_flag = false;
        int timer_counter = 0;

        while (true) {
            if (timer_interrupt_flag && interrupt_flag == 0) {
                timer_interrupt_flag = false;
                interrupt_flag = 2;

                mode = true;
                SP = 2000;
                SP--;
                PC++;
                write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                write(cpu_to_mem[1], &SP, sizeof(SP));
                write(cpu_to_mem[1], &PC, sizeof(PC));

                SP--;
                write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                write(cpu_to_mem[1], &SP, sizeof(SP));
                SP = 1000;
                write(cpu_to_mem[1], &SP, sizeof(SP));
                PC = 1000;
            }

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
                    if (operand >= 1000 && !mode) {
                        PERROR("Error: Unauthorized attempt to access system memory at address \"%d\" in user mode!", operand);
                        exit(1);
                    }
                    write(cpu_to_mem[1], &operand, sizeof(operand));
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
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    operand += X;
                    write(cpu_to_mem[1], &operand, sizeof(operand));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 5: {
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    operand += Y;
                    write(cpu_to_mem[1], &operand, sizeof(operand));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 6: {
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    operand += SP;
                    write(cpu_to_mem[1], &operand, sizeof(operand));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 7: {       // Store addr: Store the value in the AC into the address?? Need work
                    PC++;
                    operand = AC;
                    write(cpu_to_mem[1], &operand, sizeof(operand));
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
                    AC = X;
                    break;

                case 16:
                    PC++;
                    Y = AC;
                    break;
                case 17:
                    PC++;
                    AC = Y;
                    break;

                case 18:
                    PC++;
                    SP = AC;
                    break;

                case 19:
                    PC++;
                    AC = SP;
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
                    X++;
                    break;

                case 26:
                    PC++;
                    X--;
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
                    PERROR("Error: Not a command!\n");
            }
            timer_counter++;
            PC++;

            if (timer_counter == timer) {
                timer_interrupt_flag = true;
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

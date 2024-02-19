#include <iostream>
#include <cstring>
#include <unistd.h>
#include <random>

#define PERROR(FMT,...) \
  fprintf(stderr, FMT ": %s\n", ##__VA_ARGS__, strerror(errno))

using namespace std;

int *load_data(const char *file_name);

int main(int argc, const char *argv[]) {
    int mem_to_cpu[2];
    int cpu_to_mem[2];
    pid_t pid;

    const char *file_name = argv[1];
    int timer = atoi(argv[2]);
//    int timer = 30;

    int result1 = pipe(mem_to_cpu);
    int result2 = pipe(cpu_to_mem);

    if (result1 < 0 || result2 < 0) {
        printf("pipe() failed");
        exit(1);
    }

//    const char *file_name = "sample3.txt";
//    load_data(file_name);

    int buf[100];
    fflush(0);
    pid = fork();
    if (pid < 0) {
        printf("fork() failed!");
        exit(1);
    }
    else if (pid == 0) {
        // Memory process
        int *memory = load_data(file_name);
        int PC, data, address;
        PC = 0;
        data = 0;
        address = 0;
        const int write_flag = -1;
        const int kill_child = -2;

        while (true) {
            if (PC == kill_child) {
                _exit(0);
            }
            read(cpu_to_mem[0], &PC, sizeof(PC));
            if (PC == write_flag) {
                read(cpu_to_mem[0], &address, sizeof(address));
                read(cpu_to_mem[0], &data, sizeof(data));
                memory[address] = data;
            } else {
                int instruction = memory[PC];
                write(mem_to_cpu[1], &instruction, sizeof(instruction));
            }
        }
    } else {
        // CPU process
        int PC, SP, IR, AC, X, Y;
        int tempReg = 0;
        int operand = 0;

        X = 0;
        Y = 0;
        IR = 0;
        AC = 0;
        SP = 1000;
        PC = 0;

        bool kernel_mode = false; // true: kernel mode; false: user mode
        int interrupt_flag = 0;
        bool timer_interrupt_flag = false;
        int timer_counter = 0;

        const int write_flag = -1;
        const int kill_child = -2;
        const int INT_INTERRUPT_ADDR = 1499;

        while (true) {
            if (timer_interrupt_flag && interrupt_flag == 0) {
                timer_interrupt_flag = false;
                interrupt_flag = 2;

                kernel_mode = true;
                tempReg = SP;
                SP = 2000;

                SP--;
                PC++;
                write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                write(cpu_to_mem[1], &SP, sizeof(SP));
                write(cpu_to_mem[1], &PC, sizeof(PC));

                SP--;
                write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                write(cpu_to_mem[1], &SP, sizeof(SP));
                write(cpu_to_mem[1], &tempReg, sizeof(tempReg));
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
                    if (operand >= 1000 && !kernel_mode) {
                        printf("Memory violation: accessing system address %d in user mode\n", operand);
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
                    if (operand >= 1000 && !kernel_mode) {
                        printf("Memory violation: accessing system address %d in user mode\n", operand);
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
                    operand = SP + X;
                    write(cpu_to_mem[1], &operand, sizeof(operand));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    AC = operand;
                    break;
                }

                case 7: {       // Store addr: Store the value in the AC into the address?? Need work
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                    write(cpu_to_mem[1], &operand, sizeof(operand));
                    write(cpu_to_mem[1], &AC, sizeof(AC));
                    break;
                }

                case 8: {
                    std::random_device seed;
                    std::mt19937 gen{seed()}; // seed the generator
                    std::uniform_int_distribution<> dist{1, 101}; // set min and max
                    AC = dist(gen);
                    break;
                }

                case 9: {
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    if (operand == 1) {
                        printf("%i", AC);
                    } else if (operand == 2) {
                        printf("%c", AC);
                    }
                    break;
                }

                case 10:
                    AC += X;
                    break;

                case 11:
                    AC += Y;
                    break;

                case 12:
                    AC -= X;
                    break;

                case 13:
                    AC -= Y;
                    break;

                case 14:
                    X = AC;
                    break;

                case 15:
                    AC = X;
                    break;

                case 16:
                    Y = AC;
                    break;

                case 17:
                    AC = Y;
                    break;

                case 18:
                    SP = AC;
                    break;

                case 19:
                    AC = SP;
                    break;

                case 20: {
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    PC = operand + write_flag;
                    break;
                }

                case 21:
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    if (AC == 0) {
                        PC = operand + write_flag;
                    }
                    break;

                case 22:
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    if (AC != 0) {
                        PC = operand + write_flag;
                    }
                    break;

                case 23:
                    PC++;
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    read(mem_to_cpu[0], &operand, sizeof(operand));
                    SP--;
                    PC++;
                    write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    write(cpu_to_mem[1], &PC, sizeof(PC));
                    PC = operand + write_flag;
                    break;

                case 24:
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    read(mem_to_cpu[0], &PC, sizeof(PC));
                    PC--;
                    SP++;
                    break;

                case 25:
                    X++;
                    break;

                case 26:
                    X--;
                    break;

                case 27:
                    SP--;
                    write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    write(cpu_to_mem[1], &AC, sizeof(AC));
                    break;

                case 28:
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    read(mem_to_cpu[0], &AC, sizeof(AC));
                    SP++;
                    break;

                case 29:
                    if (interrupt_flag != 0) {
                        break;
                    }
                    interrupt_flag = 1;

                    kernel_mode = true;

                    tempReg = SP;
                    SP = 2000;

                    SP--;
                    write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    write(cpu_to_mem[1], &PC, sizeof(PC));

                    SP--;
                    write(cpu_to_mem[1], &write_flag, sizeof(write_flag));
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    write(cpu_to_mem[1], &tempReg, sizeof(tempReg));

                    PC = INT_INTERRUPT_ADDR;
                    break;

                case 30:
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    read(mem_to_cpu[0], &tempReg, sizeof(tempReg));
                    SP++;
                    write(cpu_to_mem[1], &SP, sizeof(SP));
                    read(mem_to_cpu[0], &PC, sizeof(PC));
                    PC -= 2;
                    SP++;

                    if (interrupt_flag == 2) {
                        timer_interrupt_flag = false;
                    }
                    interrupt_flag = 0;
                    SP = tempReg;
                    kernel_mode = false;
                    break;

                case 50:
                    write(cpu_to_mem[1], &kill_child, sizeof(kill_child));
                    exit(0);

                default:
                    printf("Error: %d not an instruction!\n", IR);
            }
            timer_counter++;
            PC++;

            if (timer_counter % timer == 0) {
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
        printf("The file %s could not be opened", file_name);
        return memory;
    }

//    int size = sizeof(memory) / sizeof(memory[0]);
//    for (int i = 0; i < size; ++i) {
//        cout << memory[i] << endl;
//    }

    while(fgets(buf, sizeof(buf), file) != nullptr) {
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

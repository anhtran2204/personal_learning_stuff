cmake_minimum_required(VERSION 3.22)
project(signal_handler C)

set(CMAKE_C_STANDARD 17)

add_executable(signal_handler main.c
        error.c)

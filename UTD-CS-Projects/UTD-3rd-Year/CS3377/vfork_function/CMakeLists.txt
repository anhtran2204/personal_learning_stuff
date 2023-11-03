cmake_minimum_required(VERSION 3.22)
project(vfork_function C)

set(CMAKE_C_STANDARD 11)

add_executable(vfork_function main.c
        error.c)

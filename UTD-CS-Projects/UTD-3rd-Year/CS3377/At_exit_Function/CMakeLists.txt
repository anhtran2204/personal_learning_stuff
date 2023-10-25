cmake_minimum_required(VERSION 3.22)
project(At_exit_Function C)

set(CMAKE_C_STANDARD 11)

add_executable(At_exit_Function doatexit.c
        error.c)

cmake_minimum_required(VERSION 3.22)
project(wait_function C)

set(CMAKE_C_STANDARD 11)

add_executable(wait_function wait1.c
        error.c)

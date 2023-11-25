cmake_minimum_required(VERSION 3.22)
project(incorrect_pthread_exit C)

set(CMAKE_C_STANDARD 11)

add_executable(incorrect_pthread_exit incorrect_pthread_exit.c
        error.c)

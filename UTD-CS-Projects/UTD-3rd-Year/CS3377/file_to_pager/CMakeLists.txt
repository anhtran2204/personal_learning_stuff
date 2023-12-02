cmake_minimum_required(VERSION 3.22)
project(file_to_pager C)

set(CMAKE_C_STANDARD 17)

add_executable(file_to_pager file_to_pager.c
        error.c)

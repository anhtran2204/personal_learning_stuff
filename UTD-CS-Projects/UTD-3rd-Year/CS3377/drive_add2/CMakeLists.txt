cmake_minimum_required(VERSION 3.22)
project(drive_add2 C)

set(CMAKE_C_STANDARD 17)

add_executable(drive_add2 add2_filter.c
        error.c
        add2.c)

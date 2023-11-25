cmake_minimum_required(VERSION 3.22)
project(race_condition C)

set(CMAKE_C_STANDARD 17)

add_executable(race_condition parent_child.c
        error.c
        tellwait.c)

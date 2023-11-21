cmake_minimum_required(VERSION 3.22)
project(worker_thread_queue C)

set(CMAKE_C_STANDARD 17)

add_executable(worker_thread_queue main.c
        thread_demo.c
        error.c)

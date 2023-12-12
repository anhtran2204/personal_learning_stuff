cmake_minimum_required(VERSION 3.22)
project(thread_cleanup_handler C)

set(CMAKE_C_STANDARD 17)

add_executable(thread_cleanup_handler error.c thread_cleanup.c)

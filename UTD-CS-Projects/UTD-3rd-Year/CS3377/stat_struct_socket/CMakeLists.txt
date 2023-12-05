cmake_minimum_required(VERSION 3.22)
project(stat_struct_socket C)

set(CMAKE_C_STANDARD 17)

add_executable(stat_struct_socket error.c socket.c)

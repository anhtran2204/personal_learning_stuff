# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.22

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/worker_thread_queue.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/worker_thread_queue.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/worker_thread_queue.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/worker_thread_queue.dir/flags.make

CMakeFiles/worker_thread_queue.dir/work_queue.c.o: CMakeFiles/worker_thread_queue.dir/flags.make
CMakeFiles/worker_thread_queue.dir/work_queue.c.o: ../work_queue.c
CMakeFiles/worker_thread_queue.dir/work_queue.c.o: CMakeFiles/worker_thread_queue.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/worker_thread_queue.dir/work_queue.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/worker_thread_queue.dir/work_queue.c.o -MF CMakeFiles/worker_thread_queue.dir/work_queue.c.o.d -o CMakeFiles/worker_thread_queue.dir/work_queue.c.o -c /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/work_queue.c

CMakeFiles/worker_thread_queue.dir/work_queue.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/worker_thread_queue.dir/work_queue.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/work_queue.c > CMakeFiles/worker_thread_queue.dir/work_queue.c.i

CMakeFiles/worker_thread_queue.dir/work_queue.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/worker_thread_queue.dir/work_queue.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/work_queue.c -o CMakeFiles/worker_thread_queue.dir/work_queue.c.s

CMakeFiles/worker_thread_queue.dir/thread_demo.c.o: CMakeFiles/worker_thread_queue.dir/flags.make
CMakeFiles/worker_thread_queue.dir/thread_demo.c.o: ../thread_demo.c
CMakeFiles/worker_thread_queue.dir/thread_demo.c.o: CMakeFiles/worker_thread_queue.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/worker_thread_queue.dir/thread_demo.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/worker_thread_queue.dir/thread_demo.c.o -MF CMakeFiles/worker_thread_queue.dir/thread_demo.c.o.d -o CMakeFiles/worker_thread_queue.dir/thread_demo.c.o -c /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/thread_demo.c

CMakeFiles/worker_thread_queue.dir/thread_demo.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/worker_thread_queue.dir/thread_demo.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/thread_demo.c > CMakeFiles/worker_thread_queue.dir/thread_demo.c.i

CMakeFiles/worker_thread_queue.dir/thread_demo.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/worker_thread_queue.dir/thread_demo.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/thread_demo.c -o CMakeFiles/worker_thread_queue.dir/thread_demo.c.s

CMakeFiles/worker_thread_queue.dir/error.c.o: CMakeFiles/worker_thread_queue.dir/flags.make
CMakeFiles/worker_thread_queue.dir/error.c.o: ../error.c
CMakeFiles/worker_thread_queue.dir/error.c.o: CMakeFiles/worker_thread_queue.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building C object CMakeFiles/worker_thread_queue.dir/error.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/worker_thread_queue.dir/error.c.o -MF CMakeFiles/worker_thread_queue.dir/error.c.o.d -o CMakeFiles/worker_thread_queue.dir/error.c.o -c /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/error.c

CMakeFiles/worker_thread_queue.dir/error.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/worker_thread_queue.dir/error.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/error.c > CMakeFiles/worker_thread_queue.dir/error.c.i

CMakeFiles/worker_thread_queue.dir/error.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/worker_thread_queue.dir/error.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/error.c -o CMakeFiles/worker_thread_queue.dir/error.c.s

# Object files for target worker_thread_queue
worker_thread_queue_OBJECTS = \
"CMakeFiles/worker_thread_queue.dir/work_queue.c.o" \
"CMakeFiles/worker_thread_queue.dir/thread_demo.c.o" \
"CMakeFiles/worker_thread_queue.dir/error.c.o"

# External object files for target worker_thread_queue
worker_thread_queue_EXTERNAL_OBJECTS =

worker_thread_queue: CMakeFiles/worker_thread_queue.dir/work_queue.c.o
worker_thread_queue: CMakeFiles/worker_thread_queue.dir/thread_demo.c.o
worker_thread_queue: CMakeFiles/worker_thread_queue.dir/error.c.o
worker_thread_queue: CMakeFiles/worker_thread_queue.dir/build.make
worker_thread_queue: CMakeFiles/worker_thread_queue.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Linking C executable worker_thread_queue"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/worker_thread_queue.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/worker_thread_queue.dir/build: worker_thread_queue
.PHONY : CMakeFiles/worker_thread_queue.dir/build

CMakeFiles/worker_thread_queue.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/worker_thread_queue.dir/cmake_clean.cmake
.PHONY : CMakeFiles/worker_thread_queue.dir/clean

CMakeFiles/worker_thread_queue.dir/depend:
	cd /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/worker_thread_queue/cmake-build-debug/CMakeFiles/worker_thread_queue.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/worker_thread_queue.dir/depend


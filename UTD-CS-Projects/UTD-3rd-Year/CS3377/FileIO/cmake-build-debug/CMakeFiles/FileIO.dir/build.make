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
CMAKE_SOURCE_DIR = /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/FileIO.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/FileIO.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/FileIO.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/FileIO.dir/flags.make

CMakeFiles/FileIO.dir/main.c.o: CMakeFiles/FileIO.dir/flags.make
CMakeFiles/FileIO.dir/main.c.o: ../main.c
CMakeFiles/FileIO.dir/main.c.o: CMakeFiles/FileIO.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/FileIO.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/FileIO.dir/main.c.o -MF CMakeFiles/FileIO.dir/main.c.o.d -o CMakeFiles/FileIO.dir/main.c.o -c /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/main.c

CMakeFiles/FileIO.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/FileIO.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/main.c > CMakeFiles/FileIO.dir/main.c.i

CMakeFiles/FileIO.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/FileIO.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/main.c -o CMakeFiles/FileIO.dir/main.c.s

# Object files for target FileIO
FileIO_OBJECTS = \
"CMakeFiles/FileIO.dir/main.c.o"

# External object files for target FileIO
FileIO_EXTERNAL_OBJECTS =

FileIO: CMakeFiles/FileIO.dir/main.c.o
FileIO: CMakeFiles/FileIO.dir/build.make
FileIO: CMakeFiles/FileIO.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable FileIO"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/FileIO.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/FileIO.dir/build: FileIO
.PHONY : CMakeFiles/FileIO.dir/build

CMakeFiles/FileIO.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/FileIO.dir/cmake_clean.cmake
.PHONY : CMakeFiles/FileIO.dir/clean

CMakeFiles/FileIO.dir/depend:
	cd /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/cmake-build-debug /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/cmake-build-debug /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/FileIO/cmake-build-debug/CMakeFiles/FileIO.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/FileIO.dir/depend


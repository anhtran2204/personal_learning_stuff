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
CMAKE_SOURCE_DIR = /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/UtilitiesFiles.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/UtilitiesFiles.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/UtilitiesFiles.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/UtilitiesFiles.dir/flags.make

CMakeFiles/UtilitiesFiles.dir/main.c.o: CMakeFiles/UtilitiesFiles.dir/flags.make
CMakeFiles/UtilitiesFiles.dir/main.c.o: ../main.c
CMakeFiles/UtilitiesFiles.dir/main.c.o: CMakeFiles/UtilitiesFiles.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/UtilitiesFiles.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/UtilitiesFiles.dir/main.c.o -MF CMakeFiles/UtilitiesFiles.dir/main.c.o.d -o CMakeFiles/UtilitiesFiles.dir/main.c.o -c /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/main.c

CMakeFiles/UtilitiesFiles.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/UtilitiesFiles.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/main.c > CMakeFiles/UtilitiesFiles.dir/main.c.i

CMakeFiles/UtilitiesFiles.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/UtilitiesFiles.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/main.c -o CMakeFiles/UtilitiesFiles.dir/main.c.s

CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o: CMakeFiles/UtilitiesFiles.dir/flags.make
CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o: ../apue.3e/proc/fork1.c
CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o: CMakeFiles/UtilitiesFiles.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o -MF CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o.d -o CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o -c /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/apue.3e/proc/fork1.c

CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/apue.3e/proc/fork1.c > CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.i

CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/apue.3e/proc/fork1.c -o CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.s

# Object files for target UtilitiesFiles
UtilitiesFiles_OBJECTS = \
"CMakeFiles/UtilitiesFiles.dir/main.c.o" \
"CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o"

# External object files for target UtilitiesFiles
UtilitiesFiles_EXTERNAL_OBJECTS =

UtilitiesFiles: CMakeFiles/UtilitiesFiles.dir/main.c.o
UtilitiesFiles: CMakeFiles/UtilitiesFiles.dir/apue.3e/proc/fork1.c.o
UtilitiesFiles: CMakeFiles/UtilitiesFiles.dir/build.make
UtilitiesFiles: CMakeFiles/UtilitiesFiles.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking C executable UtilitiesFiles"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/UtilitiesFiles.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/UtilitiesFiles.dir/build: UtilitiesFiles
.PHONY : CMakeFiles/UtilitiesFiles.dir/build

CMakeFiles/UtilitiesFiles.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/UtilitiesFiles.dir/cmake_clean.cmake
.PHONY : CMakeFiles/UtilitiesFiles.dir/clean

CMakeFiles/UtilitiesFiles.dir/depend:
	cd /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug /mnt/c/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/UTD-CS-Projects/UTD-3rd-Year/CS3377/Utilities_and_Demos/cmake-build-debug/CMakeFiles/UtilitiesFiles.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/UtilitiesFiles.dir/depend

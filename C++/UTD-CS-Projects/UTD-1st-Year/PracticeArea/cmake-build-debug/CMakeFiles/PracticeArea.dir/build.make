# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.21

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

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = D:\JetBrains\Toolbox\apps\CLion\ch-0\213.5744.254\bin\cmake\win\bin\cmake.exe

# The command to remove a file.
RM = D:\JetBrains\Toolbox\apps\CLion\ch-0\213.5744.254\bin\cmake\win\bin\cmake.exe -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "D:\Programming\CLion Projects\PracticeArea"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "D:\Programming\CLion Projects\PracticeArea\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/PracticeArea.dir/depend.make
# Include the progress variables for this target.
include CMakeFiles/PracticeArea.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/PracticeArea.dir/flags.make

CMakeFiles/PracticeArea.dir/main.cpp.obj: CMakeFiles/PracticeArea.dir/flags.make
CMakeFiles/PracticeArea.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="D:\Programming\CLion Projects\PracticeArea\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/PracticeArea.dir/main.cpp.obj"
	C:\msys64\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\PracticeArea.dir\main.cpp.obj -c "D:\Programming\CLion Projects\PracticeArea\main.cpp"

CMakeFiles/PracticeArea.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/PracticeArea.dir/main.cpp.i"
	C:\msys64\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "D:\Programming\CLion Projects\PracticeArea\main.cpp" > CMakeFiles\PracticeArea.dir\main.cpp.i

CMakeFiles/PracticeArea.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/PracticeArea.dir/main.cpp.s"
	C:\msys64\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "D:\Programming\CLion Projects\PracticeArea\main.cpp" -o CMakeFiles\PracticeArea.dir\main.cpp.s

# Object files for target PracticeArea
PracticeArea_OBJECTS = \
"CMakeFiles/PracticeArea.dir/main.cpp.obj"

# External object files for target PracticeArea
PracticeArea_EXTERNAL_OBJECTS =

PracticeArea.exe: CMakeFiles/PracticeArea.dir/main.cpp.obj
PracticeArea.exe: CMakeFiles/PracticeArea.dir/build.make
PracticeArea.exe: CMakeFiles/PracticeArea.dir/linklibs.rsp
PracticeArea.exe: CMakeFiles/PracticeArea.dir/objects1.rsp
PracticeArea.exe: CMakeFiles/PracticeArea.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="D:\Programming\CLion Projects\PracticeArea\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable PracticeArea.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\PracticeArea.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/PracticeArea.dir/build: PracticeArea.exe
.PHONY : CMakeFiles/PracticeArea.dir/build

CMakeFiles/PracticeArea.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\PracticeArea.dir\cmake_clean.cmake
.PHONY : CMakeFiles/PracticeArea.dir/clean

CMakeFiles/PracticeArea.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "D:\Programming\CLion Projects\PracticeArea" "D:\Programming\CLion Projects\PracticeArea" "D:\Programming\CLion Projects\PracticeArea\cmake-build-debug" "D:\Programming\CLion Projects\PracticeArea\cmake-build-debug" "D:\Programming\CLion Projects\PracticeArea\cmake-build-debug\CMakeFiles\PracticeArea.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/PracticeArea.dir/depend


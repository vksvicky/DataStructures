cmake_minimum_required(VERSION 3.30)
project(MyDataStructure)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Include header files directory
include_directories(.)

# Create individual libraries for each data structure
add_library(MyArray STATIC src/MyArray.cpp)
add_library(MyStack STATIC src/MyStack.cpp)
add_library(MyQueue STATIC src/MyQueue.cpp)

# Add source files
add_library(MyDataStructureLib
    src/MyArray.cpp
    src/MyStack.cpp
    src/MyQueue.cpp
)

# Include tests
add_subdirectory(tests/TDD)

# Add executable for main program (optional)
add_executable(MyDataStructure main/main.cpp)
target_link_libraries(MyDataStructure MyDataStructureLib)
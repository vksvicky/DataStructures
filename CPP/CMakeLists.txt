cmake_minimum_required(VERSION 3.30)
project(MyDataStructure)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Include header files directory
include_directories(.)
include_directories(/opt/homebrew/include)


# Create individual libraries for each data structure
add_library(MyArray STATIC src/MyArray.cpp)
add_library(MyStack STATIC src/MyStack.cpp)
add_library(MyQueue STATIC src/MyQueue.cpp)

# Add source files
add_library(MyDataStructureLib
    src/MyArray.cpp
    src/MyStack.cpp
    src/MyQueue.cpp
    src/MyLinkedList.cpp
    src/MyDeque.cpp
    src/MyHashMap.cpp
    src/MySet.cpp
    src/MyPriorityQueue.cpp
)

enable_testing()

# Include TDD tests
add_subdirectory(tests/TDD)

# Include BDD tests
add_subdirectory(tests/BDD)

# Add executable for main program (optional)
add_executable(MyDataStructure main/main.cpp)
target_link_libraries(MyDataStructure MyDataStructureLib)

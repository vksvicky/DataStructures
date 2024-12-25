cmake_minimum_required(VERSION 3.30)
project(MyArrayProject)

set(CMAKE_CXX_STANDARD 17)

include_directories(include)

add_library(MyArray STATIC src/MyArray.cpp)

enable_testing()
find_package(GTest REQUIRED)
include_directories(${GTEST_INCLUDE_DIRS})

add_executable(MyArrayTDD tests/TDD/MyArrayTDD.cpp)
target_link_libraries(MyArrayTDD MyArray GTest::GTest GTest::Main)

add_executable(MyArrayBDD tests/BDD/MyArrayBDD.cpp)
target_link_libraries(MyArrayBDD MyArray GTest::GTest GTest::Main)

add_executable(MyArrayMain main/main.cpp)
target_link_libraries(MyArrayMain MyArray)
cmake_minimum_required(VERSION 3.12)
project(MyArray VERSION 1.0.0 LANGUAGES CXX)

# Use modern C++
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Include GNUInstallDirs for standard installation directories
include(GNUInstallDirs)

# Create the library
add_library(MyArray STATIC
    src/MyArray.cpp
)

# Create the main executable
add_executable(MyArrayMain 
    src/main.cpp
)
target_link_libraries(MyArrayMain PRIVATE MyArray)

# Set up installation paths and rules
install(TARGETS MyArray
    EXPORT MyArrayTargets
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    ARCHIVE DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)

install(DIRECTORY include/
    DESTINATION ${CMAKE_INSTALL_INCLUDEDIR}
    FILES_MATCHING PATTERN "*.h"
    PATTERN "*.hpp"
)

install(TARGETS MyArrayMain
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)

# Export targets
install(EXPORT MyArrayTargets
    FILE MyArrayTargets.cmake
    DESTINATION ${CMAKE_INSTALL_LIBDIR}/cmake/MyArray
)


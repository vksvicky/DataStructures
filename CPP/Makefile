# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Iinclude

# Test compilation flags
TEST_FLAGS = -lgtest -lgtest_main -pthread

# Source files
MAIN_SRC = src/MyArrayMain.cpp
TDD_SRC = tests/TDD/MyArrayTDD.cpp
BDD_SRC = tests/BDD/MyArrayBDD.cpp
LIB_SRC = src/MyArray.cpp

# Object files
LIB_OBJ = $(LIB_SRC:.cpp=.o)

# Targets
all: MyArrayMain MyArrayTDD MyArrayBDD

# Main executable
MyArrayMain: $(MAIN_SRC) libMyArray.a
	$(CXX) $(CXXFLAGS) $^ -o $@ -L. -lMyArray

# Test executables
MyArrayTDD: $(TDD_SRC) libMyArray.a
	$(CXX) $(CXXFLAGS) $^ -o $@ -L. -lMyArray $(TEST_FLAGS)

MyArrayBDD: $(BDD_SRC) libMyArray.a
	$(CXX) $(CXXFLAGS) $^ -o $@ -L. -lMyArray $(TEST_FLAGS)

# Static library
libMyArray.a: $(LIB_OBJ)
	ar rcs $@ $^

# Object files
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Clean target
clean:
	rm -f MyArrayMain MyArrayTDD MyArrayBDD libMyArray.a $(LIB_OBJ)

.PHONY: all clean


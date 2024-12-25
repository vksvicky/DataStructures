//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../header/MyArray.h"
#include <stdexcept>  // For std::out_of_range

// Constructor: Initialize the array to default values
MyArray::MyArray() {
    for (size_t i = 0; i < N; ++i) {
        data[i] = 0;  // Default initialize to 0
    }
}

// Access element with bounds checking
int& MyArray::at(size_t index) {
    if (index >= N) {
        throw std::out_of_range("Index out of range");
    }
    return data[index];
}

const int& MyArray::at(size_t index) const {
    if (index >= N) {
        throw std::out_of_range("Index out of range");
    }
    return data[index];
}

// Access element without bounds checking
int& MyArray::operator[](size_t index) {
    return data[index];  // No bounds checking
}

const int& MyArray::operator[](size_t index) const {
    return data[index];  // No bounds checking
}

// Return the size of the array
size_t MyArray::size() const {
    return N;
}

// Fill the array with a given value
void MyArray::fill(int value) {
    for (size_t i = 0; i < N; ++i) {
        data[i] = value;
    }
}

// Check if the array is empty (all elements are default-initialized)
bool MyArray::empty() const {
    for (size_t i = 0; i < N; ++i) {
        if (data[i] != 0) {  // Assuming default is 0
            return false;
        }
    }
    return true;
}
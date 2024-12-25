//
// Created by Vivek Krishnan on 20/12/2024.
//

#ifndef MYARRAY_H
#define MYARRAY_H

#include <cstddef>  // For size_t
#include <stdexcept>  // For exceptions

class MyArray {
private:
    static const size_t N = 5;  // Size of the array
    int data[N];  // Array to hold data

public:
    MyArray();  // Constructor to initialize elements

    // Access element with bounds checking
    int& at(size_t index);
    const int& at(size_t index) const;

    // Access element without bounds checking
    int& operator[](size_t index);
    const int& operator[](size_t index) const;

    // Get the size of the array
    size_t size() const;

    // Fill the array with a given value
    void fill(int value);

    // Check if the array is empty (all elements are default-initialized)
    bool empty() const;
};

#endif
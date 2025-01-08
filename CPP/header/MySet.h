//
// Created by Vivek Krishnan on 08/01/2025.
//

#ifndef MYSET_H
#define MYSET_H

#include <vector>
#include <stdexcept>
#include <iostream>

// Custom implementation of a Set data structure
class MySet {
private:
    std::vector<int> elements; // Store unique elements

    // Check if an element already exists in the set
    bool contains(int element) const;

public:
    // Constructor
    MySet() = default;

    // Destructor
    ~MySet() = default;

    // Add an element to the set
    void add(int element);

    // Remove an element from the set
    void remove(int element);

    // Check if an element exists in the set
    bool exists(int element) const;

    // Get the number of elements in the set
    int size() const;

    // Check if the set is empty
    bool isEmpty() const;

    // Get all elements of the set
    std::vector<int> getElements() const;

    // Clear all elements in the set
    void clear();
};

#endif // MYSET_H

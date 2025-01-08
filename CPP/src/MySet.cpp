//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../header/MySet.h"

// Check if an element exists in the set
bool MySet::contains(int element) const {
    for (const int& el : elements) {
        if (el == element) {
            return true;
        }
    }
    return false;
}

// Add an element to the set
void MySet::add(int element) {
    if (!contains(element)) {
        elements.push_back(element);
    }
}

// Remove an element from the set
void MySet::remove(int element) {
    for (auto it = elements.begin(); it != elements.end(); ++it) {
        if (*it == element) {
            elements.erase(it);
            return;
        }
    }
    throw std::out_of_range("Element not found in the set");
}

// Check if an element exists in the set
bool MySet::exists(int element) const {
    return contains(element);
}

// Get the number of elements in the set
int MySet::size() const {
    return elements.size();
}

// Check if the set is empty
bool MySet::isEmpty() const {
    return elements.empty();
}

// Get all elements of the set
std::vector<int> MySet::getElements() const {
    return elements;
}

// Clear all elements in the set
void MySet::clear() {
    elements.clear();
}

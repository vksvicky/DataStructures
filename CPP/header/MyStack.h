//
// Created by Vivek Krishnan on 06/01/2025.
//

#ifndef MYSTACK_H
#define MYSTACK_H

#include <cstddef>  // For size_t
#include <stdexcept>  // For exceptions

class MyStack {
private:
    static const size_t MAX_SIZE = 100;  // Maximum size of the stack
    int data[MAX_SIZE];  // Array to store stack elements
    size_t top;  // Index of the top element (-1 if the stack is empty)

public:
    MyStack();  // Constructor to initialize the stack

    // Push an element onto the stack
    void push(int value);

    // Pop an element from the stack
    int pop();

    // Peek the top element without removing it
    int peek() const;

    // Check if the stack is empty
    bool empty() const;

    // Check if the stack is full
    bool full() const;

    // Get the current size of the stack
    size_t size() const;
};

#endif

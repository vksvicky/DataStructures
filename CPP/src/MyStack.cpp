//
// Created by Vivek Krishnan on 06/01/2025.
//

#include "../header/MyStack.h"

// Constructor: Initialize the stack
MyStack::MyStack() : top(0) {}

// Push an element onto the stack
void MyStack::push(int value) {
    if (full()) {
        throw std::overflow_error("Stack overflow: Cannot push onto a full stack");
    }
    data[top++] = value;
}

// Pop an element from the stack
int MyStack::pop() {
    if (empty()) {
        throw std::underflow_error("Stack underflow: Cannot pop from an empty stack");
    }
    return data[--top];
}

// Peek the top element without removing it
int MyStack::peek() const {
    if (empty()) {
        throw std::underflow_error("Stack underflow: Cannot peek an empty stack");
    }
    return data[top - 1];
}

// Check if the stack is empty
bool MyStack::empty() const {
    return top == 0;
}

// Check if the stack is full
bool MyStack::full() const {
    return top == MAX_SIZE;
}

// Get the current size of the stack
size_t MyStack::size() const {
    return top;
}

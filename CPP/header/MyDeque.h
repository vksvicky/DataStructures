//
// Created by Vivek Krishnan on 08/01/2025.
//

#ifndef MYDEQUE_H
#define MYDEQUE_H

#include <stdexcept>
#include <iostream>

// Node structure for the deque
class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node(int value) : data(value), next(nullptr), prev(nullptr) {}
};

// MyDeque class definition
class MyDeque {
private:
    Node* front;
    Node* rear;
    int size;

public:
    // Constructor
    MyDeque();

    // Destructor
    ~MyDeque();

    // Add an element to the front
    void pushFront(int value);

    // Add an element to the rear
    void pushBack(int value);

    // Remove an element from the front
    int popFront();

    // Remove an element from the rear
    int popBack();

    // Get the element at the front
    int getFront() const;

    // Get the element at the rear
    int getRear() const;

    // Check if the deque is empty
    bool isEmpty() const;

    // Get the size of the deque
    int getSize() const;

    // Display the contents of the deque
    void display() const;
};

#endif // MYDEQUE_H

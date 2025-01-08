//
// Created by Vivek Krishnan on 08/01/2025.
//

#ifndef MYLINKEDLIST_H
#define MYLINKEDLIST_H

#include <stdexcept>
#include <iostream>

// Node class representing a single element in the linked list
class Node {
public:
    int data;      // Value of the node
    Node* next;    // Pointer to the next node

    // Constructor
    Node(int value) : data(value), next(nullptr) {}
};

// MyLinkedList class representing the linked list
class MyLinkedList {
private:
    Node* head;    // Pointer to the head of the list
    int size;      // Number of elements in the list

public:
    // Constructor
    MyLinkedList();

    // Destructor
    ~MyLinkedList();

    // Append an element to the end of the list
    void append(int value);

    // Prepend an element to the beginning of the list
    void prepend(int value);

    // Remove an element at a specific position
    void removeAt(int index);

    // Get the value of an element at a specific position
    int getAt(int index) const;

    // Get the size of the linked list
    int getSize() const;

    // Display the contents of the linked list
    void display() const;
};

#endif // MYLINKEDLIST_H

//
// Created by Vivek Krishnan on 08/01/2025.
//

#ifndef MYPRIORITYQUEUE_H
#define MYPRIORITYQUEUE_H

#include <vector>
#include <stdexcept>
#include <algorithm>
#include <iostream>

// Custom implementation of a Priority Queue
class MyPriorityQueue {
private:
    std::vector<int> heap; // Internal vector to represent the heap

    // Helper functions to manage the heap
    void heapifyUp(int index);
    void heapifyDown(int index);

    int parent(int index) const { return (index - 1) / 2; }
    int leftChild(int index) const { return 2 * index + 1; }
    int rightChild(int index) const { return 2 * index + 2; }

public:
    // Constructor
    MyPriorityQueue() = default;

    // Destructor
    ~MyPriorityQueue() = default;

    // Insert an element into the priority queue
    void push(int value);

    // Remove and return the highest-priority element
    int pop();

    // Peek at the highest-priority element without removing it
    int top() const;

    // Check if the priority queue is empty
    bool isEmpty() const;

    // Get the size of the priority queue
    int size() const;

    // Clear all elements in the priority queue
    void clear();
};

#endif // MYPRIORITYQUEUE_H

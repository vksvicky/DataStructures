//
// Created by Vivek Krishnan on 06/01/2025.
//

#ifndef MYQUEUE_H
#define MYQUEUE_H

#include <cstddef>  // For size_t
#include <stdexcept>  // For exceptions

// MyQueue class for integer-based queue implementation
class MyQueue {
private:
    static const size_t MAX_SIZE = 100;  // Maximum queue size
    int data[MAX_SIZE];  // Array to store queue elements
    size_t front;  // Index of the front element
    size_t rear;   // Index of the rear element
    size_t count;  // Number of elements in the queue

public:
    // Constructor to initialize the queue
    MyQueue();

    // Enqueue an element into the queue
    void enqueue(int value);

    // Dequeue an element from the queue
    int dequeue();

    // Peek the front element without removing it
    int peek() const;

    // Check if the queue is empty
    bool empty() const;

    // Check if the queue is full
    bool full() const;

    // Get the current size of the queue
    size_t size() const;
};

#endif

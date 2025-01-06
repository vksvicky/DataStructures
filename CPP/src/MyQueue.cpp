//
// Created by Vivek Krishnan on 06/01/2025.
//

#include "../header/MyQueue.h"

// Constructor: Initialize an empty queue
MyQueue::MyQueue() : front(0), rear(0), count(0) {}

// Enqueue an element into the queue
void MyQueue::enqueue(int value) {
    if (full()) {
        throw std::overflow_error("Queue overflow: Cannot enqueue into a full queue");
    }
    data[rear] = value;             // Add element at rear position
    rear = (rear + 1) % MAX_SIZE;   // Move rear to the next position (circular indexing)
    count++;                        // Increment the number of elements
}

// Dequeue an element from the queue
int MyQueue::dequeue() {
    if (empty()) {
        throw std::underflow_error("Queue underflow: Cannot dequeue from an empty queue");
    }
    int value = data[front];        // Retrieve the front element
    front = (front + 1) % MAX_SIZE; // Move front to the next position (circular indexing)
    count--;                        // Decrement the number of elements
    return value;
}

// Peek the front element without removing it
int MyQueue::peek() const {
    if (empty()) {
        throw std::underflow_error("Queue underflow: Cannot peek an empty queue");
    }
    return data[front];
}

// Check if the queue is empty
bool MyQueue::empty() const {
    return count == 0;
}

// Check if the queue is full
bool MyQueue::full() const {
    return count == MAX_SIZE;
}

// Get the current size of the queue
size_t MyQueue::size() const {
    return count;
}

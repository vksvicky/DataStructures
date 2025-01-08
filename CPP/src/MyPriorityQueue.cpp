//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../header/MyPriorityQueue.h"

// Insert an element into the priority queue
void MyPriorityQueue::push(int value) {
    heap.push_back(value);
    heapifyUp(heap.size() - 1);
}

// Remove and return the highest-priority element
int MyPriorityQueue::pop() {
    if (isEmpty()) {
        throw std::out_of_range("Priority Queue is empty");
    }

    int topValue = heap.front();
    heap.front() = heap.back();
    heap.pop_back();

    if (!isEmpty()) {
        heapifyDown(0);
    }

    return topValue;
}

// Peek at the highest-priority element without removing it
int MyPriorityQueue::top() const {
    if (isEmpty()) {
        throw std::out_of_range("Priority Queue is empty");
    }

    return heap.front();
}

// Check if the priority queue is empty
bool MyPriorityQueue::isEmpty() const {
    return heap.empty();
}

// Get the size of the priority queue
int MyPriorityQueue::size() const {
    return heap.size();
}

// Clear all elements in the priority queue
void MyPriorityQueue::clear() {
    heap.clear();
}

// Heapify up to maintain the max-heap property
void MyPriorityQueue::heapifyUp(int index) {
    while (index > 0 && heap[parent(index)] < heap[index]) {
        std::swap(heap[parent(index)], heap[index]);
        index = parent(index);
    }
}

// Heapify down to maintain the max-heap property
void MyPriorityQueue::heapifyDown(int index) {
    int largest = index;
    int left = leftChild(index);
    int right = rightChild(index);

    if (left < heap.size() && heap[left] > heap[largest]) {
        largest = left;
    }
    if (right < heap.size() && heap[right] > heap[largest]) {
        largest = right;
    }
    if (largest != index) {
        std::swap(heap[index], heap[largest]);
        heapifyDown(largest);
    }
}

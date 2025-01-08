//
// Created by Vivek Krishnan on 06/01/2025.
//

#include "../header/MyDeque.h"

// Constructor
MyDeque::MyDeque() : front(nullptr), rear(nullptr), size(0) {}

// Destructor
MyDeque::~MyDeque() {
    Node* current = front;
    while (current) {
        Node* temp = current;
        current = current->next;
        delete temp;
    }
}

// Add an element to the front
void MyDeque::pushFront(int value) {
    Node* newNode = new Node(value);
    if (isEmpty()) {
        front = rear = newNode;
    } else {
        newNode->next = front;
        front->prev = newNode;
        front = newNode;
    }
    size++;
}

// Add an element to the rear
void MyDeque::pushBack(int value) {
    Node* newNode = new Node(value);
    if (isEmpty()) {
        front = rear = newNode;
    } else {
        newNode->prev = rear;
        rear->next = newNode;
        rear = newNode;
    }
    size++;
}

// Remove an element from the front
int MyDeque::popFront() {
    if (isEmpty()) {
        throw std::underflow_error("Deque is empty");
    }
    int value = front->data;
    Node* temp = front;
    front = front->next;
    if (front) {
        front->prev = nullptr;
    } else {
        rear = nullptr;
    }
    delete temp;
    size--;
    return value;
}

// Remove an element from the rear
int MyDeque::popBack() {
    if (isEmpty()) {
        throw std::underflow_error("Deque is empty");
    }
    int value = rear->data;
    Node* temp = rear;
    rear = rear->prev;
    if (rear) {
        rear->next = nullptr;
    } else {
        front = nullptr;
    }
    delete temp;
    size--;
    return value;
}

// Get the element at the front
int MyDeque::getFront() const {
    if (isEmpty()) {
        throw std::underflow_error("Deque is empty");
    }
    return front->data;
}

// Get the element at the rear
int MyDeque::getRear() const {
    if (isEmpty()) {
        throw std::underflow_error("Deque is empty");
    }
    return rear->data;
}

// Check if the deque is empty
bool MyDeque::isEmpty() const {
    return size == 0;
}

// Get the size of the deque
int MyDeque::getSize() const {
    return size;
}

// Display the contents of the deque
void MyDeque::display() const {
    Node* temp = front;
    while (temp) {
        std::cout << temp->data << " ";
        temp = temp->next;
    }
    std::cout << std::endl;
}

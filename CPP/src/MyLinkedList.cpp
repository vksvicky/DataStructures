//
// Created by Vivek Krishnan on 06/01/2025.
//

#include "../header/MyLinkedList.h"

// Constructor
MyLinkedList::MyLinkedList() : head(nullptr), size(0) {}

// Destructor
MyLinkedList::~MyLinkedList() {
    Node* current = head;
    while (current) {
        Node* temp = current;
        current = current->next;
        delete temp;
    }
}

// Append an element to the end of the list
void MyLinkedList::append(int value) {
    Node* newNode = new Node(value);
    if (!head) {
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
    size++;
}

// Prepend an element to the beginning of the list
void MyLinkedList::prepend(int value) {
    Node* newNode = new Node(value);
    newNode->next = head;
    head = newNode;
    size++;
}

// Remove an element at a specific position
void MyLinkedList::removeAt(int index) {
    if (index < 0 || index >= size) {
        throw std::out_of_range("Index out of range");
    }
    if (index == 0) {
        Node* temp = head;
        head = head->next;
        delete temp;
    } else {
        Node* temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp->next;
        }
        Node* toDelete = temp->next;
        temp->next = toDelete->next;
        delete toDelete;
    }
    size--;
}

// Get the value of an element at a specific position
int MyLinkedList::getAt(int index) const {
    if (index < 0 || index >= size) {
        throw std::out_of_range("Index out of range");
    }
    Node* temp = head;
    for (int i = 0; i < index; i++) {
        temp = temp->next;
    }
    return temp->data;
}

// Get the size of the linked list
int MyLinkedList::getSize() const {
    return size;
}

// Display the contents of the linked list
void MyLinkedList::display() const {
    Node* temp = head;
    while (temp) {
        std::cout << temp->data << " -> ";
        temp = temp->next;
    }
    std::cout << "NULL" << std::endl;
}

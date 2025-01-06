//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../header/MyArray.h"
#include "../header/MyStack.h"
#include "../header/MyQueue.h"
#include <iostream>

int myArray() {
    MyArray arr;
    arr.fill(3);

    std::cout << "Array elements: ";
    for (size_t i = 0; i < arr.size(); ++i) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}

int myStack() {
    MyStack stack;

    stack.push(10);
    stack.push(20);

    std::cout << "Top element: " << stack.peek() << "\n";
    std::cout << "Popped element: " << stack.pop() << "\n";

    stack.push(30);
    std::cout << "Top element after push: " << stack.peek() << "\n";

    return 0;
}

int myQueue() {
    MyQueue queue;

    try {
        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);

        std::cout << "Front element: " << queue.peek() << "\n";  // Should output 10
        std::cout << "Dequeued: " << queue.dequeue() << "\n";    // Should output 10

        queue.enqueue(30);
        std::cout << "Front element: " << queue.peek() << "\n";  // Should output 20
        std::cout << "Dequeued: " << queue.dequeue() << "\n";    // Should output 20
        std::cout << "Dequeued: " << queue.dequeue() << "\n";    // Should output 30

        // Attempt to dequeue from an empty queue
        std::cout << "Dequeued: " << queue.dequeue() << "\n";    // Should throw an error
    } catch (const std::exception &e) {
        std::cerr << "Error: " << e.what() << "\n";
    }

    return 0;
}

int main() {
    myArray();
    myStack();  
    myQueue(); 
}


//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../../header/MyQueue.h"
#include <catch2/catch_test_macros.hpp>

// Scenario: Enqueuing elements into the queue
TEST_CASE("Enqueuing elements into the queue", "[MyQueueBDD]") {
    // Given an empty queue
    MyQueue queue;

    // When elements are enqueued
    queue.enqueue(5);
    queue.enqueue(10);

    // Then the size should reflect the number of elements
    REQUIRE(queue.size() == 2);

    // And the front element should be the first enqueued element
    REQUIRE(queue.peek() == 5);
}

// Scenario: Dequeuing elements from the queue
TEST_CASE("Dequeuing elements from the queue", "[MyQueueBDD]") {
    // Given a queue with multiple elements
    MyQueue queue;
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    // When an element is dequeued
    int dequeued = queue.dequeue();

    // Then the dequeued element should be the first enqueued element
    REQUIRE(dequeued == 1);

    // And the size should decrease
    REQUIRE(queue.size() == 2);

    // And the front element should update to the next in line
    REQUIRE(queue.peek() == 2);
}

// Scenario: Handling queue overflow
TEST_CASE("Handling queue overflow", "[MyQueueBDD]") {
    // Given a queue that reaches maximum capacity
    MyQueue queue;
    for (size_t i = 0; i < 100; ++i) {
        queue.enqueue(i);
    }

    // When trying to enqueue beyond the maximum capacity
    // Then an overflow exception should be thrown
    REQUIRE_THROWS_AS(queue.enqueue(101), std::overflow_error);
}

// Scenario: Handling queue underflow
TEST_CASE("Handling queue underflow", "[MyQueueBDD]") {
    // Given an empty queue
    MyQueue queue;

    // When trying to dequeue from an empty queue
    // Then an underflow exception should be thrown
    REQUIRE_THROWS_AS(queue.dequeue(), std::underflow_error);

    // And when trying to peek into an empty queue
    // Then an underflow exception should also be thrown
    REQUIRE_THROWS_AS(queue.peek(), std::underflow_error);
}

// Scenario: Circular behavior of the queue
TEST_CASE("Circular behavior of the queue", "[MyQueueBDD]") {
    // Given a queue that becomes full
    MyQueue queue;
    for (size_t i = 0; i < 100; ++i) {
        queue.enqueue(i);
    }

    // When elements are dequeued to create space
    for (size_t i = 0; i < 10; ++i) {
        REQUIRE(queue.dequeue() == i);
    }

    // And new elements are enqueued
    for (size_t i = 100; i < 110; ++i) {
        queue.enqueue(i);
    }

    // Then the queue should maintain correct order
    REQUIRE(queue.peek() == 10);
    for (size_t i = 10; i < 110; ++i) {
        REQUIRE(queue.dequeue() == i);
    }

    // And the queue should be empty after all elements are dequeued
    REQUIRE(queue.empty());
}

// Scenario: Enqueue and dequeue multiple elements
TEST_CASE("Enqueue and dequeue multiple elements", "[MyQueueBDD]") {
    // Given an empty queue
    MyQueue queue;

    // When multiple elements are enqueued
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);

    // Then the size should reflect the total elements
    REQUIRE(queue.size() == 3);

    // And the front element should be the first enqueued
    REQUIRE(queue.peek() == 20);

    // When elements are dequeued one by one
    REQUIRE(queue.dequeue() == 20);
    REQUIRE(queue.dequeue() == 30);
    REQUIRE(queue.dequeue() == 40);

    // Then the queue should be empty
    REQUIRE(queue.empty());

    // And dequeuing again should throw an underflow exception
    REQUIRE_THROWS_AS(queue.dequeue(), std::underflow_error);
}


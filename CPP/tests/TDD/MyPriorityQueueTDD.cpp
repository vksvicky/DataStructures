//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyPriorityQueue.h"
#include <gtest/gtest.h>

// Happy path tests
TEST(MyPriorityQueueTest, InsertAndRetrieve) {
    MyPriorityQueue pq;
    pq.push(10);
    pq.push(20);
    EXPECT_EQ(pq.top(), 20);
    EXPECT_EQ(pq.size(), 2);
}

// Negative and exception handling tests
TEST(MyPriorityQueueTest, PopFromEmptyQueue) {
    MyPriorityQueue pq;
    EXPECT_THROW(pq.pop(), std::out_of_range);
}

// Error cases
TEST(MyPriorityQueueTest, TopFromEmptyQueue) {
    MyPriorityQueue pq;
    EXPECT_THROW(pq.top(), std::out_of_range);
}

// Big-O performance test
TEST(MyPriorityQueueTest, BigOInsertions) {
    MyPriorityQueue pq;
    const int N = 10000;

    for (int i = 0; i < N; ++i) {
        pq.push(i);
    }

    EXPECT_EQ(pq.size(), N);
    for (int i = N - 1; i >= 0; --i) {
        EXPECT_EQ(pq.pop(), i);
    }
}

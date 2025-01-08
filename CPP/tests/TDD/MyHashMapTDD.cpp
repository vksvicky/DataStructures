//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyHashMap.h"
#include <gtest/gtest.h>

// Happy path tests
TEST(MyHashMapTest, InsertAndRetrieve) {
    MyHashMap map;
    map.put(1, 10);
    map.put(2, 20);
    EXPECT_EQ(map.get(1), 10);
    EXPECT_EQ(map.get(2), 20);
}

// Negative and exception handling tests
TEST(MyHashMapTest, KeyNotFound) {
    MyHashMap map;
    EXPECT_THROW(map.get(99), std::out_of_range);
}

// Error cases
TEST(MyHashMapTest, RemoveNonExistentKey) {
    MyHashMap map;
    EXPECT_THROW(map.remove(99), std::out_of_range);
}

// Big-O performance test (example)
TEST(MyHashMapTest, BigOInsertions) {
    MyHashMap map;
    const int N = 10000;

    for (int i = 0; i < N; ++i) {
        map.put(i, i * 10);
    }

    EXPECT_EQ(map.getSize(), N);
    for (int i = 0; i < N; ++i) {
        EXPECT_EQ(map.get(i), i * 10);
    }
}

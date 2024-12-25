//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../../header//MyArray.h"
#include <gtest/gtest.h>

// Scenario: Accessing and modifying elements
TEST(MyArrayBDD, AccessModifyScenario) {
    // Given an array of size 5
    MyArray arr;

    // When I set the first element to 10
    arr[0] = 10;

    // Then the first element should be 10
    EXPECT_EQ(arr[0], 10);

    // And accessing an out-of-bounds index should throw an exception
    EXPECT_THROW(arr.at(5), std::out_of_range);
}
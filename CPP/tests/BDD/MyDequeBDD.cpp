//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyDeque.h"
#include <catch2/catch_test_macros.hpp>

SCENARIO("Performing deque operations", "[BDD]") {
    GIVEN("An empty deque") {
        MyDeque deque;

        THEN("It should be empty") {
            REQUIRE(deque.isEmpty());
            REQUIRE(deque.getSize() == 0);
        }

        WHEN("Elements are added to the front and back") {
            deque.pushFront(10);
            deque.pushBack(20);

            THEN("The size increases and elements are correctly positioned") {
                REQUIRE(deque.getSize() == 2);
                REQUIRE(deque.getFront() == 10);
                REQUIRE(deque.getRear() == 20);
            }
        }

        WHEN("Elements are removed from an empty deque") {
            THEN("An exception is thrown") {
                REQUIRE_THROWS_AS(deque.popFront(), std::underflow_error);
                REQUIRE_THROWS_AS(deque.popBack(), std::underflow_error);
            }
        }
    }
}

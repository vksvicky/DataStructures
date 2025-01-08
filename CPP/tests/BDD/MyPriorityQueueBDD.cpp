//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyPriorityQueue.h"
#include <catch2/catch_test_macros.hpp>

SCENARIO("Using MyPriorityQueue to manage prioritized elements", "[BDD]") {
    GIVEN("An empty priority queue") {
        MyPriorityQueue pq;

        THEN("It should be empty initially") {
            REQUIRE(pq.isEmpty());
        }

        WHEN("Adding elements to the queue") {
            pq.push(10);
            pq.push(20);

            THEN("The highest priority element should be retrievable") {
                REQUIRE(pq.top() == 20);
                REQUIRE(pq.size() == 2);
            }
        }

        WHEN("Removing elements from the queue") {
            pq.push(30);
            pq.push(15);
            pq.pop();

            THEN("The next highest priority element should be retrievable") {
                REQUIRE(pq.top() == 15);
            }
        }

        WHEN("Popping from an empty queue") {
            THEN("An exception should be thrown") {
                REQUIRE_THROWS_AS(pq.pop(), std::out_of_range);
            }
        }

        WHEN("Clearing the queue") {
            pq.push(50);
            pq.push(25);
            pq.clear();

            THEN("The queue should be empty") {
                REQUIRE(pq.isEmpty());
                REQUIRE(pq.size() == 0);
            }
        }
    }
}

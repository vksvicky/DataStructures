//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyHashMap.h"
#include <catch2/catch_test_macros.hpp>

SCENARIO("Using MyHashMap for key-value operations", "[BDD]") {
    GIVEN("An empty hashmap") {
        MyHashMap map;

        THEN("It should be empty") {
            REQUIRE(map.isEmpty());
        }

        WHEN("Inserting key-value pairs") {
            map.put(1, 10);
            map.put(2, 20);

            THEN("The size should increase and keys should be retrievable") {
                REQUIRE(map.getSize() == 2);
                REQUIRE(map.get(1) == 10);
                REQUIRE(map.get(2) == 20);
            }
        }

        WHEN("Removing a non-existent key") {
            THEN("An exception should be thrown") {
                REQUIRE_THROWS_AS(map.remove(99), std::out_of_range);
            }
        }

        WHEN("The load factor is exceeded") {
            const int largeInsertions = 10000;

            for (int i = 0; i < largeInsertions; ++i) {
                map.put(i, i * 10);
            }

            THEN("All keys should be retrievable after resizing") {
                REQUIRE(map.getSize() == largeInsertions);
                for (int i = 0; i < largeInsertions; ++i) {
                    REQUIRE(map.get(i) == i * 10);
                }
            }
        }
    }
}

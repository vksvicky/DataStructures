//
// Created by Vivek Krishnan on 08/01/2025.
//

#ifndef MYHASHMAP_H
#define MYHASHMAP_H

#include <vector>
#include <list>
#include <utility>
#include <stdexcept>
#include <iostream>

// MyHashMap class definition
class MyHashMap {
private:
    static const int DEFAULT_CAPACITY = 16; // Default number of buckets
    static const float LOAD_FACTOR;        // Load factor for resizing

    std::vector<std::list<std::pair<int, int>>> buckets; // Buckets for storing key-value pairs
    int size; // Number of key-value pairs
    int capacity; // Number of buckets

    // Hash function
    int hash(int key) const;

    // Resize the hashmap when load factor is exceeded
    void resize();

public:
    // Constructor
    MyHashMap();

    // Destructor
    ~MyHashMap() = default;

    // Insert or update a key-value pair
    void put(int key, int value);

    // Get the value associated with a key
    int get(int key) const;

    // Remove a key-value pair
    void remove(int key);

    // Check if the hashmap contains a key
    bool containsKey(int key) const;

    // Get the current size of the hashmap
    int getSize() const;

    // Check if the hashmap is empty
    bool isEmpty() const;
};

#endif // MYHASHMAP_H

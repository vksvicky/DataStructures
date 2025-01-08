//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../header/MyHashMap.h"

const float MyHashMap::LOAD_FACTOR = 0.75;

// Constructor
MyHashMap::MyHashMap() : size(0), capacity(DEFAULT_CAPACITY), buckets(DEFAULT_CAPACITY) {}

// Hash function
int MyHashMap::hash(int key) const {
    return key % capacity;
}

// Resize the hashmap when the load factor is exceeded
void MyHashMap::resize() {
    int newCapacity = capacity * 2;
    std::vector<std::list<std::pair<int, int>>> newBuckets(newCapacity);

    for (const auto& bucket : buckets) {
        for (const auto& pair : bucket) {
            int newIndex = pair.first % newCapacity;
            newBuckets[newIndex].push_back(pair);
        }
    }

    buckets = std::move(newBuckets);
    capacity = newCapacity;
}

// Insert or update a key-value pair
void MyHashMap::put(int key, int value) {
    int index = hash(key);

    for (auto& pair : buckets[index]) {
        if (pair.first == key) {
            pair.second = value; // Update value if key already exists
            return;
        }
    }

    buckets[index].emplace_back(key, value);
    size++;

    if (size > capacity * LOAD_FACTOR) {
        resize();
    }
}

// Get the value associated with a key
int MyHashMap::get(int key) const {
    int index = hash(key);

    for (const auto& pair : buckets[index]) {
        if (pair.first == key) {
            return pair.second;
        }
    }

    throw std::out_of_range("Key not found");
}

// Remove a key-value pair
void MyHashMap::remove(int key) {
    int index = hash(key);

    for (auto it = buckets[index].begin(); it != buckets[index].end(); ++it) {
        if (it->first == key) {
            buckets[index].erase(it);
            size--;
            return;
        }
    }

    throw std::out_of_range("Key not found");
}

// Check if the hashmap contains a key
bool MyHashMap::containsKey(int key) const {
    int index = hash(key);

    for (const auto& pair : buckets[index]) {
        if (pair.first == key) {
            return true;
        }
    }

    return false;
}

// Get the current size of the hashmap
int MyHashMap::getSize() const {
    return size;
}

// Check if the hashmap is empty
bool MyHashMap::isEmpty() const {
    return size == 0;
}

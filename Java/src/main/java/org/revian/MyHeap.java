package org.revian;

import java.util.Arrays;

public class MyHeap {
    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyHeap() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // Resize the heap array if necessary
    private void resize() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    // Insert element into the heap
    public void insert(int value) {
        resize();
        heap[size] = value;
        size++;
        heapifyUp(size - 1); // Maintain the heap property
    }

    // Heapify up to maintain the heap property
    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Extract the minimum element (root) from the heap
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1]; // Replace the root with the last element
        size--;
        heapifyDown(0); // Restore the heap property
        return min;
    }

    // Heapify down to maintain the heap property after extracting the min
    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest); // Recursively heapify down
        }
    }

    // Peek at the minimum element (root)
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // Convert an unsorted array into a heap
    public void heapify(int[] array) {
        heap = array;
        size = array.length;
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Swap two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Helper methods to get parent and child indices
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // For testing purposes: method to get the current size of the heap
    public int getSize() {
        return size;
    }
}

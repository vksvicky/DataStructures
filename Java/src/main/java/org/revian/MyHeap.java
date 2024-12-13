package org.revian;

import java.util.ArrayList;
import java.util.List;

public class MyHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MyHeap() {
        heap = new ArrayList<>();
    }

    public void insert(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public T removeMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T result = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return result;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;
        while (index < heap.size() / 2) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = leftChild;

            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) {
                smallest = rightChild;
            }

            if (heap.get(index).compareTo(heap.get(smallest)) <= 0) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}


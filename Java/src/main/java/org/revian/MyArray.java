package org.revian;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size >= array.length) {
            throw new IndexOutOfBoundsException("Array is full");
        }
        array[size++] = value;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    public int size() {
        return size;
    }
}

package org.revian;

public class MyStack {
    private int[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        stack = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(int value) {
        if (size >= stack.length) {
            throw new StackOverflowError("Stack is full");
        }
        stack[size++] = value;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[--size];
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[size - 1];
    }

    public int size() {
        return size;
    }
}


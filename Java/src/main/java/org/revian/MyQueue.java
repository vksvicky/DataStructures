package org.revian;

public class MyQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        queue = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}

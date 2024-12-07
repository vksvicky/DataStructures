package org.revian;

import java.util.LinkedList;

public class MyDeque {
    private LinkedList<Integer> deque;

    public MyDeque() {
        deque = new LinkedList<>();
    }

    public void addFirst(int value) {
        deque.addFirst(value);
    }

    public void addLast(int value) {
        deque.addLast(value);
    }

    public int removeFirst() {
        if (deque.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return deque.removeFirst();
    }

    public int removeLast() {
        if (deque.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }
}

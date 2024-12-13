package org.revian;

import java.util.ArrayList;
import java.util.List;

public class MySet<T> {
    private List<T> elements;

    public MySet() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (!contains(element)) {
            elements.add(element);
        }
    }

    public void remove(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        elements.remove(element);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

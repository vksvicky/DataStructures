package org.revian;

public class MyLinkedList {
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid index");
            }
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}


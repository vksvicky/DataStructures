namespace Datastructure;

using System;
using System.Collections.Generic;

public class MyLinkedList<T>
{
    private Node _head;
    private Node _tail;
    private int _count;

    public MyLinkedList()
    {
        _head = null;
        _tail = null;
        _count = 0;
    }

    // Nested Node class
    private class Node
    {
        public T Data;
        public Node Next;

        public Node(T data)
        {
            Data = data;
            Next = null;
        }
    }

    // Add an element to the front of the list
    public void AddFirst(T item)
    {
        var newNode = new Node(item);
        if (_head == null)
        {
            _head = newNode;
            _tail = newNode;
        }
        else
        {
            newNode.Next = _head;
            _head = newNode;
        }
        _count++;
    }

    // Add an element to the end of the list
    public void AddLast(T item)
    {
        var newNode = new Node(item);
        if (_tail == null)
        {
            _head = newNode;
            _tail = newNode;
        }
        else
        {
            _tail.Next = newNode;
            _tail = newNode;
        }
        _count++;
    }

    // Get the element at the specified index
    public T Get(int index)
    {
        if (index < 0 || index >= _count)
        {
            throw new InvalidOperationException("Index is out of range.");
        }

        var current = _head;
        for (int i = 0; i < index; i++)
        {
            current = current.Next;
        }

        return current.Data;
    }

    // Remove the first element from the list
    public T RemoveFirst()
    {
        if (_head == null)
        {
            throw new InvalidOperationException("List is empty.");
        }

        var value = _head.Data;
        _head = _head.Next;

        if (_head == null) // If the list is now empty, reset the tail
        {
            _tail = null;
        }

        _count--;
        return value;
    }

    // Remove the last element from the list
    public T RemoveLast()
    {
        if (_tail == null)
        {
            throw new InvalidOperationException("List is empty.");
        }

        if (_head == _tail)
        {
            var value = _tail.Data;
            _head = _tail = null;
            _count--;
            return value;
        }

        var current = _head;
        while (current.Next != _tail)
        {
            current = current.Next;
        }

        var lastValue = _tail.Data;
        _tail = current;
        _tail.Next = null;

        _count--;
        return lastValue;
    }

    // Peek the first element in the list
    public T Peek()
    {
        if (_head == null)
        {
            throw new InvalidOperationException("List is empty.");
        }

        return _head.Data;
    }

    // Check if the list is empty
    public bool IsEmpty()
    {
        return _count == 0;
    }

    // Get the number of elements in the list
    public int Count()
    {
        return _count;
    }
}

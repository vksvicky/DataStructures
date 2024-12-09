namespace Datastructure;

using System;
using System.Collections.Generic;

public class MyQueue<T>
{
    private LinkedList<T> _elements;

    public MyQueue()
    {
        _elements = new LinkedList<T>();
    }

    // Enqueue an item into the queue
    public void Enqueue(T item)
    {
        _elements.AddLast(item);  // Adds item to the end of the queue
    }

    // Dequeue an item from the queue
    public T Dequeue()
    {
        if (_elements.Count == 0)
        {
            throw new InvalidOperationException("Queue is empty.");
        }

        var value = _elements.First.Value;
        _elements.RemoveFirst();  // Removes the first item from the queue
        return value;
    }

    // Peek at the first item without removing it
    public T Peek()
    {
        if (_elements.Count == 0)
        {
            throw new InvalidOperationException("Queue is empty.");
        }

        return _elements.First.Value;  // Returns the first item without removing it
    }

    // Check if the queue is empty
    public bool IsEmpty()
    {
        return _elements.Count == 0;
    }

    // Get the number of items in the queue
    public int Count()
    {
        return _elements.Count;
    }
}

namespace Datastructure;

using System;

public class MyDeque<T>
{
    private LinkedList<T> _deque;

    public MyDeque()
    {
        _deque = new LinkedList<T>();
    }

    // Add an element to the front of the deque
    public void AddFirst(T item)
    {
        _deque.AddFirst(item);
    }

    // Add an element to the end of the deque
    public void AddLast(T item)
    {
        _deque.AddLast(item);
    }

    // Remove and return the element at the front
    public T RemoveFirst()
    {
        if (_deque.Count == 0)
        {
            throw new InvalidOperationException("Deque is empty.");
        }

        var value = _deque.First.Value;
        _deque.RemoveFirst();
        return value;
    }

    // Remove and return the element at the end
    public T RemoveLast()
    {
        if (_deque.Count == 0)
        {
            throw new InvalidOperationException("Deque is empty.");
        }

        var value = _deque.Last.Value;
        _deque.RemoveLast();
        return value;
    }

    // Peek at the first element without removing it
    public T PeekFirst()
    {
        if (_deque.Count == 0)
        {
            throw new InvalidOperationException("Deque is empty.");
        }

        return _deque.First.Value;
    }

    // Peek at the last element without removing it
    public T PeekLast()
    {
        if (_deque.Count == 0)
        {
            throw new InvalidOperationException("Deque is empty.");
        }

        return _deque.Last.Value;
    }

    // Check if the deque is empty
    public bool IsEmpty()
    {
        return _deque.Count == 0;
    }

    // Return the number of elements in the deque
    public int Count()
    {
        return _deque.Count;
    }
}

namespace Datastructure;

using System;
using System.Collections.Generic;

public class MyStack<T>
{
    private List<T> _elements;

    public MyStack()
    {
        _elements = new List<T>();
    }

    // Push item to the stack
    public void Push(T item)
    {
        _elements.Add(item);
    }

    // Pop item from the stack
    public T Pop()
    {
        if (_elements.Count == 0)
        {
            throw new InvalidOperationException("Stack is empty.");
        }
        T item = _elements[_elements.Count - 1];
        _elements.RemoveAt(_elements.Count - 1);
        return item;
    }

    // Peek the top item without removing it
    public T Peek()
    {
        if (_elements.Count == 0)
        {
            throw new InvalidOperationException("Stack is empty.");
        }
        return _elements[_elements.Count - 1];
    }

    // Check if the stack is empty
    public bool IsEmpty()
    {
        return _elements.Count == 0;
    }

    // Get the number of items in the stack
    public int Count()
    {
        return _elements.Count;
    }
}

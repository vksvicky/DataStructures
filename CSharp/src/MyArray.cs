namespace CSharp;

public class MyArray
{
    private int[] _array;
    private int _size;
    private int _capacity;

    public MyArray(int capacity = 4)
    {
        _capacity = capacity;
        _array = new int[capacity];
        _size = 0;
    }

    // Add an element to the array
    public void Add(int value)
    {
        if (_size == _capacity)
        {
            Resize();
        }
        _array[_size] = value;
        _size++;
    }

    // Resize the array when it is full
    private void Resize()
    {
        _capacity *= 2;
        int[] newArray = new int[_capacity];
        for (int i = 0; i < _size; i++)
        {
            newArray[i] = _array[i];
        }
        _array = newArray;
    }

    // Get an element by index
    public int Get(int index)
    {
        if (index < 0 || index >= _size)
        {
            throw new IndexOutOfRangeException("Index is out of bounds");
        }
        return _array[index];
    }

    // Get the current size of the array
    public int Size()
    {
        return _size;
    }
}


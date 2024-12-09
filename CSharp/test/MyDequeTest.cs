using Datastructure;
using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace CSharp.Test;

[TestFixture]
public class MyDequeTest
{
    // Set up before each test
    [SetUp]
    public void Setup()
    {
        _deque = new MyDeque<int>();
    }

    private MyDeque<int> _deque;

    // Happy Path: Add elements to the front of the deque
    [Test]
    public void AddFirst_ShouldAddElementToFront()
    {
        _deque.AddFirst(10);
        _deque.AddFirst(20);

        ClassicAssert.AreEqual(2, _deque.Count()); // The deque should contain 2 elements
        ClassicAssert.AreEqual(20, _deque.PeekFirst()); // The first element should be 20
    }

    // Happy Path: Add elements to the end of the deque
    [Test]
    public void AddLast_ShouldAddElementToEnd()
    {
        _deque.AddLast(10);
        _deque.AddLast(20);

        ClassicAssert.AreEqual(2, _deque.Count()); // The deque should contain 2 elements
        ClassicAssert.AreEqual(20, _deque.PeekLast()); // The last element should be 20
    }

    // Happy Path: Remove element from the front of the deque
    [Test]
    public void RemoveFirst_ShouldRemoveElementFromFront()
    {
        _deque.AddFirst(10);
        _deque.AddFirst(20);

        var removedElement = _deque.RemoveFirst();

        ClassicAssert.AreEqual(20, removedElement); // The first element should be 20
        ClassicAssert.AreEqual(1, _deque.Count()); // The deque should contain 1 element
        ClassicAssert.AreEqual(10, _deque.PeekFirst()); // The first element should now be 10
    }

    // Happy Path: Remove element from the end of the deque
    [Test]
    public void RemoveLast_ShouldRemoveElementFromEnd()
    {
        _deque.AddLast(10);
        _deque.AddLast(20);

        var removedElement = _deque.RemoveLast();

        ClassicAssert.AreEqual(20, removedElement); // The last element should be 20
        ClassicAssert.AreEqual(1, _deque.Count()); // The deque should contain 1 element
        ClassicAssert.AreEqual(10, _deque.PeekLast()); // The last element should now be 10
    }

    // Negative Path: Try to remove from an empty deque
    [Test]
    public void RemoveFirst_ShouldThrowException_WhenDequeIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _deque.RemoveFirst()); // Expecting exception
    }

    // Negative Path: Try to remove from an empty deque
    [Test]
    public void RemoveLast_ShouldThrowException_WhenDequeIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _deque.RemoveLast()); // Expecting exception
    }

    // Error Handling: Try to peek the first element when deque is empty
    [Test]
    public void PeekFirst_ShouldThrowException_WhenDequeIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _deque.PeekFirst()); // Expecting exception
    }

    // Error Handling: Try to peek the last element when deque is empty
    [Test]
    public void PeekLast_ShouldThrowException_WhenDequeIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _deque.PeekLast()); // Expecting exception
    }

    // Edge Case: Add and remove a single element
    [Test]
    public void AddAndRemoveSingleElement_ShouldWorkCorrectly()
    {
        _deque.AddFirst(10);
        var removedElement = _deque.RemoveFirst();

        ClassicAssert.AreEqual(10, removedElement); // The only element should be 10
        ClassicAssert.IsTrue(_deque.IsEmpty()); // The deque should be empty after removal
    }

    // Edge Case: Add and remove multiple elements
    [Test]
    public void AddAndRemoveMultipleElements_ShouldWorkCorrectly()
    {
        _deque.AddFirst(10);
        _deque.AddFirst(20);
        _deque.AddLast(30);
        _deque.AddLast(40);

        var removedFirst = _deque.RemoveFirst();
        var removedLast = _deque.RemoveLast();

        ClassicAssert.AreEqual(20, removedFirst); // The first element should be 20
        ClassicAssert.AreEqual(40, removedLast); // The last element should be 40
        ClassicAssert.AreEqual(2, _deque.Count()); // The deque should have 2 elements left
    }

    // Edge Case: Check if deque is empty after operations
    [Test]
    public void IsEmpty_ShouldReturnTrue_WhenDequeIsEmpty()
    {
        ClassicAssert.IsTrue(_deque.IsEmpty()); // The deque should be empty
    }

    // Check the count after operations
    [Test]
    public void Count_ShouldReturnCorrectNumberOfElements()
    {
        _deque.AddFirst(10);
        _deque.AddFirst(20);

        ClassicAssert.AreEqual(2, _deque.Count()); // The deque should contain 2 elements
    }
}
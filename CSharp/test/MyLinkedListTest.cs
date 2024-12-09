using Datastructure;
using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace CSharp.Test;

[TestFixture]
public class MyLinkedListTest
{
    private MyLinkedList<int> _linkedList;

    // Set up before each test
    [SetUp]
    public void Setup()
    {
        _linkedList = new MyLinkedList<int>();
    }

    // Happy Path: Add first element to an empty list
    [Test]
    public void AddFirst_ShouldAddElementToEmptyList()
    {
        _linkedList.AddFirst(10);

        ClassicAssert.AreEqual(1, _linkedList.Count()); // List should contain 1 element
        ClassicAssert.AreEqual(10, _linkedList.Get(0)); // The first element should be 10
    }

    // Happy Path: Add multiple elements to the list
    [Test]
    public void AddLast_ShouldAddElementsToList()
    {
        _linkedList.AddFirst(10);
        _linkedList.AddLast(20);
        _linkedList.AddLast(30);

        ClassicAssert.AreEqual(3, _linkedList.Count()); // List should contain 3 elements
        ClassicAssert.AreEqual(10, _linkedList.Get(0)); // First element should be 10
        ClassicAssert.AreEqual(30, _linkedList.Get(2)); // Last element should be 30
    }

    // Negative Path: Get an element from an empty list
    [Test]
    public void Get_ShouldThrowException_WhenListIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _linkedList.Get(0)); // Expecting exception
    }

    // Error Handling: Remove from an empty list
    [Test]
    public void RemoveFirst_ShouldThrowException_WhenListIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _linkedList.RemoveFirst()); // Expecting exception
    }

    // Happy Path: Remove the first element from the list
    [Test]
    public void RemoveFirst_ShouldRemoveElementFromList()
    {
        _linkedList.AddFirst(10);
        _linkedList.AddFirst(20);

        var removedElement = _linkedList.RemoveFirst();

        ClassicAssert.AreEqual(20, removedElement); // The first element (20) should be removed
        ClassicAssert.AreEqual(1, _linkedList.Count()); // List should have 1 element left
    }

    // Negative Path: Remove the last element from a single-element list
    [Test]
    public void RemoveLast_ShouldThrowException_WhenListIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _linkedList.RemoveLast()); // Expecting exception
    }

    // Happy Path: Peek the first element in the list
    [Test]
    public void Peek_ShouldReturnFirstElement()
    {
        _linkedList.AddFirst(10);
        _linkedList.AddLast(20);

        var peekElement = _linkedList.Peek();

        ClassicAssert.AreEqual(10, peekElement); // The first element should be 10
    }

    // Edge Case: Remove the last element from the list
    [Test]
    public void RemoveLast_ShouldRemoveLastElement()
    {
        _linkedList.AddFirst(10);
        _linkedList.AddLast(20);

        var removedElement = _linkedList.RemoveLast();

        ClassicAssert.AreEqual(20, removedElement); // The last element (20) should be removed
        ClassicAssert.AreEqual(1, _linkedList.Count()); // List should have 1 element left
    }

    // Edge Case: Check if the list is empty
    [Test]
    public void IsEmpty_ShouldReturnTrue_WhenListIsEmpty()
    {
        ClassicAssert.IsTrue(_linkedList.IsEmpty()); // The list should be empty
    }

    // Edge Case: Add and remove elements repeatedly
    [Test]
    public void AddAndRemoveElements_ShouldWorkCorrectly()
    {
        _linkedList.AddFirst(10);
        _linkedList.AddLast(20);
        _linkedList.RemoveFirst();

        ClassicAssert.AreEqual(1, _linkedList.Count()); // List should contain 1 element
        ClassicAssert.AreEqual(20, _linkedList.Get(0)); // The only element left should be 20
    }
}
using Datastructure;
using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace CSharp.Tests;

[TestFixture]
public class StackTest
{
    private MyStack<int> _stack;

    // Set up before each test
    [SetUp]
    public void Setup()
    {
        _stack = new MyStack<int>();
    }

    // Happy Path: Push an item to the stack
    [Test]
    public void Push_ShouldAddItemToStack()
    {
        _stack.Push(10);

        ClassicAssert.AreEqual(1, _stack.Count()); // Stack should contain 1 item
        ClassicAssert.AreEqual(10, _stack.Peek()); // The top item should be 10
    }

    // Happy Path: Pop an item from the stack
    [Test]
    public void Pop_ShouldReturnCorrectItem()
    {
        _stack.Push(10);
        _stack.Push(20);

        var poppedItem = _stack.Pop();

        ClassicAssert.AreEqual(20, poppedItem); // The last pushed item should be popped first
        ClassicAssert.AreEqual(1, _stack.Count()); // Stack should have 1 item left
    }

    // Negative Path: Trying to pop from an empty stack
    [Test]
    public void Pop_ShouldThrowException_WhenStackIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _stack.Pop()); // Expecting exception
    }

    // Error Handling: Trying to peek from an empty stack
    [Test]
    public void Peek_ShouldThrowException_WhenStackIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _stack.Peek()); // Expecting exception
    }

    // Happy Path: Pushing multiple items to the stack
    [Test]
    public void Push_ShouldAddMultipleItemsToStack()
    {
        _stack.Push(10);
        _stack.Push(20);
        _stack.Push(30);

        ClassicAssert.AreEqual(3, _stack.Count()); // Stack should contain 3 items
        ClassicAssert.AreEqual(30, _stack.Peek()); // The top item should be 30
    }

    // Edge Case: Check if stack is empty
    [Test]
    public void IsEmpty_ShouldReturnTrue_WhenStackIsEmpty()
    {
        ClassicAssert.IsTrue(_stack.IsEmpty()); // The stack should be empty
    }

    // Edge Case: Check if stack is empty after push/pop operations
    [Test]
    public void IsEmpty_ShouldReturnFalse_WhenStackHasItems()
    {
        _stack.Push(10);

        ClassicAssert.IsFalse(_stack.IsEmpty()); // The stack should not be empty after pushing an item
    }

    // Error Handling: Peek returns correct value when multiple elements are present
    [Test]
    public void Peek_ShouldReturnCorrectItem_WhenMultipleItemsArePushed()
    {
        _stack.Push(10);
        _stack.Push(20);
        _stack.Push(30);

        var topItem = _stack.Peek();

        ClassicAssert.AreEqual(30, topItem); // The top item should be 30
    }
}
using Datastructure;
using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace CSharp.Test;

[TestFixture]
public class MyQueueTest
{
    private MyQueue<int> _queue;

    // Set up before each test
    [SetUp]
    public void Setup()
    {
        _queue = new MyQueue<int>();
    }

    // Happy Path: Enqueue an item to the queue
    [Test]
    public void Enqueue_ShouldAddItemToQueue()
    {
        _queue.Enqueue(10);

        ClassicAssert.AreEqual(1, _queue.Count()); // The queue should contain 1 item
        ClassicAssert.AreEqual(10, _queue.Peek()); // The first item should be 10
    }

    // Happy Path: Dequeue an item from the queue
    [Test]
    public void Dequeue_ShouldReturnCorrectItem()
    {
        _queue.Enqueue(10);
        _queue.Enqueue(20);

        var dequeuedItem = _queue.Dequeue();

        ClassicAssert.AreEqual(10, dequeuedItem); // The first item enqueued should be dequeued first
        ClassicAssert.AreEqual(1, _queue.Count()); // The queue should have 1 item left
    }

    // Negative Path: Trying to dequeue from an empty queue
    [Test]
    public void Dequeue_ShouldThrowException_WhenQueueIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _queue.Dequeue()); // Expecting exception
    }

    // Error Handling: Trying to peek from an empty queue
    [Test]
    public void Peek_ShouldThrowException_WhenQueueIsEmpty()
    {
        Assert.Throws<InvalidOperationException>(() => _queue.Peek()); // Expecting exception
    }

    // Happy Path: Enqueue multiple items to the queue
    [Test]
    public void Enqueue_ShouldAddMultipleItemsToQueue()
    {
        _queue.Enqueue(10);
        _queue.Enqueue(20);
        _queue.Enqueue(30);

        ClassicAssert.AreEqual(3, _queue.Count()); // The queue should contain 3 items
        ClassicAssert.AreEqual(10, _queue.Peek()); // The first item should be 10 (FIFO order)
    }

    // Edge Case: Check if queue is empty
    [Test]
    public void IsEmpty_ShouldReturnTrue_WhenQueueIsEmpty()
    {
        ClassicAssert.IsTrue(_queue.IsEmpty()); // The queue should be empty
    }

    // Edge Case: Check if queue is empty after enqueue/dequeue operations
    [Test]
    public void IsEmpty_ShouldReturnFalse_WhenQueueHasItems()
    {
        _queue.Enqueue(10);

        ClassicAssert.IsFalse(_queue.IsEmpty()); // The queue should not be empty after enqueueing an item
    }

    // Error Handling: Peek returns correct value when multiple elements are present
    [Test]
    public void Peek_ShouldReturnCorrectItem_WhenMultipleItemsAreEnqueued()
    {
        _queue.Enqueue(10);
        _queue.Enqueue(20);
        _queue.Enqueue(30);

        var frontItem = _queue.Peek();

        ClassicAssert.AreEqual(10, frontItem); // The front item should be 10 (FIFO order)
    }

    // Edge Case: Dequeue all items and check if the queue is empty
    [Test]
    public void Dequeue_ShouldEmptyQueue_WhenAllItemsAreDequeued()
    {
        _queue.Enqueue(10);
        _queue.Enqueue(20);
        _queue.Enqueue(30);

        _queue.Dequeue();
        _queue.Dequeue();
        _queue.Dequeue();

        ClassicAssert.IsTrue(_queue.IsEmpty()); // The queue should be empty
    }
}
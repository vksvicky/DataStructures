package org.revian

import org.scalatest.funsuite.AnyFunSuite

class MyQueueTest extends AnyFunSuite {

  test("Enqueue element into MyQueue") {
    val queue = new MyQueue(3)
    queue.enqueue(1)
    assert(queue.size() == 1)
  }

  test("Dequeue element from MyQueue") {
    val queue = new MyQueue(3)
    queue.enqueue(1)
    queue.enqueue(2)
    assert(queue.dequeue() == 1)
    assert(queue.size() == 1)
  }

  test("Dequeue from empty MyQueue should throw exception") {
    val queue = new MyQueue(3)
    assertThrows[IllegalStateException] {
      queue.dequeue()
    }
  }

  test("Enqueue beyond capacity should throw exception") {
    val queue = new MyQueue(3)
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    assertThrows[IllegalStateException] {
      queue.enqueue(4)
    }
  }

  test("Circular behavior - wrap around") {
    val queue = new MyQueue(3)
    queue.enqueue(1)
    queue.enqueue(2)
    queue.dequeue()
    queue.enqueue(3)
    assert(queue.size() == 2)
    assert(queue.dequeue() == 2)
    assert(queue.dequeue() == 3)
  }
}

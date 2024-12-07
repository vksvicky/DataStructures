package org.revian

class MyQueue(capacity: Int) {
  private var queue = List[Int]()
  private val maxCapacity = capacity

  def enqueue(value: Int): Unit = {
    if (queue.size >= maxCapacity) {
      throw new IllegalStateException("Queue is full")
    }
    queue = queue :+ value
  }

  def dequeue(): Int = {
    if (queue.isEmpty) throw new IllegalStateException("Queue is empty")
    val first = queue.head
    queue = queue.tail
    first
  }

  def size(): Int = queue.length
}

package org.revian

class MyDeque {
  private var deque = List[Int]()

  def addFirst(value: Int): Unit = {
    deque = value :: deque
  }

  def addLast(value: Int): Unit = {
    deque = deque :+ value
  }

  def removeFirst(): Int = {
    if (deque.isEmpty) throw new NoSuchElementException("Deque is empty")
    val first = deque.head
    deque = deque.tail
    first
  }

  def removeLast(): Int = {
    if (deque.isEmpty) throw new NoSuchElementException("Deque is empty")
    val last = deque.last
    deque = deque.init
    last
  }

  def size(): Int = deque.length
}

package org.revian

class MyStack {
  private var stack = List[Int]()

  def push(value: Int): Unit = {
    stack = value :: stack
  }

  def pop(): Int = {
    if (stack.isEmpty) throw new IllegalStateException("Stack is empty")
    val top = stack.head
    stack = stack.tail
    top
  }

  def size(): Int = stack.length
}

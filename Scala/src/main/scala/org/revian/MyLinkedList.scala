package org.revian

class MyLinkedList {
  private class Node(val value: Int, var next: Option[Node])

  private var head: Option[Node] = None

  def add(value: Int): Unit = {
    val newNode = new Node(value, head)
    head = Some(newNode)
  }

  def get(index: Int): Int = {
    var current = head
    var count = 0
    while (current.isDefined && count < index) {
      current = current.get.next
      count += 1
    }
    current match {
      case Some(node) => node.value
      case None => throw new IndexOutOfBoundsException("Index out of bounds")
    }
  }

  def size(): Int = {
    var current = head
    var count = 0
    while (current.isDefined) {
      count += 1
      current = current.get.next
    }
    count
  }
}


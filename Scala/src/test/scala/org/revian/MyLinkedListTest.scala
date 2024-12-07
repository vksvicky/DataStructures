package org.revian

import org.scalatest.funsuite.AnyFunSuite

class MyLinkedListTest extends AnyFunSuite {

  test("Add element to LinkedList") {
    val linkedList = new MyLinkedList
    linkedList.add(10)
    assert(linkedList.size() == 1)
    assert(linkedList.get(0) == 10)
  }

  test("Get element by index") {
    val linkedList = new MyLinkedList
    linkedList.add(10)
    linkedList.add(20)
    assert(linkedList.get(0) == 20)
    assert(linkedList.get(1) == 10)
  }

  test("Get element out of bounds should throw exception") {
    val linkedList = new MyLinkedList
    linkedList.add(10)
    linkedList.add(20)
    assertThrows[IndexOutOfBoundsException] {
      linkedList.get(3)
    }
  }

  test("Get from empty LinkedList should throw exception") {
    val linkedList = new MyLinkedList
    assertThrows[IndexOutOfBoundsException] {
      linkedList.get(0)
    }
  }

  test("Size of LinkedList should be correct") {
    val linkedList = new MyLinkedList
    linkedList.add(10)
    linkedList.add(20)
    linkedList.add(30)
    assert(linkedList.size() == 3)
  }
}

package org.revian

import org.scalatest.funsuite.AnyFunSuite

class MyDequeTest extends AnyFunSuite {

  val myDeque = new MyDeque

  test("Add and remove from front of deque") {
    myDeque.addFirst(10)
    assert(myDeque.size() == 1)
    assert(myDeque.removeFirst() == 10)
  }

  test("Add and remove from back of deque") {
    myDeque.addLast(20)
    assert(myDeque.size() == 1)
    assert(myDeque.removeLast() == 20)
  }

  test("Remove from empty deque should throw exception") {
    assertThrows[NoSuchElementException] {
      myDeque.removeFirst()
    }
  }
}

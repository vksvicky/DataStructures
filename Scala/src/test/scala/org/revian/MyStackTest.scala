package org.revian

import org.scalatest.funsuite.AnyFunSuite

class MyStackTest extends AnyFunSuite {

  val myStack = new MyStack

  test("Push element onto stack") {
    myStack.push(10)
    assert(myStack.size() == 1)
  }

  test("Pop element from stack") {
    myStack.push(10)
    assert(myStack.pop() == 10)
    assert(myStack.size() == 0)
  }

  test("Pop from empty stack should throw exception") {
    assertThrows[IllegalStateException] {
      myStack.pop()
    }
  }
}

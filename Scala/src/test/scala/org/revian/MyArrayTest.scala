package org.revian

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter

class MyArrayTest extends AnyFunSuite with BeforeAndAfter {

  var myArray: MyArray = _

  before {
    myArray = new MyArray(3)
  }

  test("Add element to MyArray") {
    myArray.add(1)
    assert(myArray.size() == 1)
    assert(myArray.get(0) == 1)
  }

  test("Add element beyond capacity") {
    myArray.add(1)
    myArray.add(2)
    myArray.add(3)
    assertThrows[ArrayIndexOutOfBoundsException] {
      myArray.add(4)
    }
  }

  test("Get element at index") {
    myArray.add(10)
    myArray.add(20)
    assert(myArray.get(0) == 10)
    assert(myArray.get(1) == 20)
  }

  test("Get element out of bounds") {
    assertThrows[IndexOutOfBoundsException] {
      myArray.get(3)
    }
  }
}

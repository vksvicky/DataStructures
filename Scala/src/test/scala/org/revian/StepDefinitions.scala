package org.revian

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import org.scalatest.Assertions._

class StepDefinitions extends ScalaDsl with EN with Matchers {

  var myArray: MyArray = _
  var myStack: MyStack = _
  var myQueue: MyQueue = _

  Given("""^I have an empty MyArray with capacity (\d+)$""") { (capacity: Int) =>
    myArray = new MyArray(capacity)
  }

  When("""^I add (\d+) to the MyArray$""") { (value: Int) =>
    myArray.add(value)
  }

  Then("""^the size of the MyArray should be (\d+)$""") { (size: Int) =>
    myArray.size() shouldEqual size
  }

  Then("""^the capacity should have increased$""") {
    assert(myArray.size() > 3)
  }

//  Given("""^I have a mocked MyStack$""") {
//    myStack = mock(classOf[MyStack])
//  }
//
//  When("""^I attempt to pop from the empty stack$""") {
//    when(myStack.pop()).thenThrow(new IllegalStateException("Stack is empty"))
//  }

  Then("""^an IllegalStateException should be thrown$""") {
    assertThrows[IllegalStateException] {
      myStack.pop()
    }
  }

  Given("""^I have an empty MyQueue with capacity (\d+)$""") { (capacity: Int) =>
    myQueue = new MyQueue(capacity)
  }

  When("""^I enqueue (\d+)$""") { (value: Int) =>
    myQueue.enqueue(value)
  }

  And("""^I dequeue$""") {
    myQueue.dequeue()
  }

  Then("""^the size of the Queue should be (\d+)$""") { (size: Int) =>
    myQueue.size() shouldEqual size
  }

  Then("""^the first element should be (\d+)$""") { (value: Int) =>
    myQueue.dequeue() shouldEqual value
  }

  Given("""^I have an empty MyQueue with capacity (\d+)$""") { (capacity: Int) =>
    myQueue = new MyQueue(capacity)
  }

  When("""^I enqueue (\d+)$""") { (value: Int) =>
    myQueue.enqueue(value)
  }

  And("""^I dequeue$""") {
    myQueue.dequeue()
  }

  Then("""^the size of the Queue should be (\d+)$""") { (size: Int) =>
    myQueue.size() shouldEqual size
  }

  Then("""^the first element should be (\d+)$""") { (value: Int) =>
    myQueue.dequeue() shouldEqual value
  }

  Then("""^an IllegalStateException should be thrown when I enqueue (\d+)$""") { (value: Int) =>
    assertThrows[IllegalStateException] {
      myQueue.enqueue(value)
    }
  }
}

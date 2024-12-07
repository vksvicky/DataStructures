package org.revian

class MyArray(capacity: Int) {
  private var arr = new Array[Int](capacity)
  private var arraySize = 0

  def add(value: Int): Unit = {
    if (arraySize == arr.length) {
      throw new ArrayIndexOutOfBoundsException("Array is full!")
    }
    arr(arraySize) = value
    arraySize += 1
  }

  def get(index: Int): Int = {
    if (index >= arraySize) throw new IndexOutOfBoundsException("Index out of bounds")
    arr(index)
  }

  def size(): Int = arraySize
}

using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace CSharp.Test;

[TestFixture]
public class MyArrayTest
{
    // Happy Path: Add and Get element
    [Test]
    public void Test_Add_Get_Item()
    {
        var customArray = new MyArray();
        customArray.Add(10);
        int result = customArray.Get(0);
        //Assert.AreEqual(10, result); // Expect 10
        ClassicAssert.AreEqual(10, result);
    }

    // Negative Path: Access element with invalid index
    [Test]
    public void Test_Get_InvalidIndex()
    {
        var myArray = new MyArray();
        myArray.Add(10);
        Assert.Throws<IndexOutOfRangeException>(() => myArray.Get(5)); // Invalid index
    }

    // Happy Path: Resize array when full
    [Test]
    public void Test_Resize_Array()
    {
        var myArray = new MyArray(2);
        myArray.Add(10);
        myArray.Add(20);
        myArray.Add(30);  // Triggers resize
        ClassicAssert.AreEqual(30, myArray.Get(2)); // New element after resizing
    }
}


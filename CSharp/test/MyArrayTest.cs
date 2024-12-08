public class myArrayTests
{
    // Happy Path: Add and Get element
    public void Test_Add_Get_Item()
    {
        var myArray = new myArray();
        myArray.Add(10);
        int result = myArray.Get(0);
        Assert.AreEqual(10, result); // Expect 10
    }

    // Negative Path: Access element with invalid index
    public void Test_Get_InvalidIndex()
    {
        var myArray = new myArray();
        myArray.Add(10);
        Assert.Throws<IndexOutOfRangeException>(() => customArray.Get(5)); // Invalid index
    }

    // Happy Path: Resize array when full
    public void Test_Resize_Array()
    {
        var myArray = new myArray(2);
        myArray.Add(10);
        myArray.Add(20);
        myArray.Add(30);  // Triggers resize
        Assert.AreEqual(30, myArray.Get(2)); // New element after resizing
    }
}

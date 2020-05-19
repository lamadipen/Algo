package kata.stackqueue;

import org.junit.Assert;
import org.junit.Test;

/** Cracking the code page 99 */
public class StackOfPlatesTest {
    @Test
    public void pushTest() {
        StackOfPlates stackOfPlates = new StackOfPlates(2);

        stackOfPlates.push(10);
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Integer peek = stackOfPlates.stacks.get(0).peek();
        Assert.assertEquals(Integer.valueOf(10), peek);
        stackOfPlates.push(11);
        stackOfPlates.push(12);
        Assert.assertEquals(2,stackOfPlates.stacks.size() );

        Assert.assertEquals(12,stackOfPlates.pop() );
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Assert.assertEquals(11,stackOfPlates.pop() );
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Assert.assertEquals(10,stackOfPlates.pop() );
        Assert.assertEquals(0,stackOfPlates.stacks.size() );
        Assert.assertEquals(-1,stackOfPlates.currentPointer );
        stackOfPlates.push(10);
        Assert.assertEquals(0,stackOfPlates.currentPointer );
    }


    @Test
    public void pushBookImplementationTest() {
        StackOfPlatesFromBook stackOfPlates = new StackOfPlatesFromBook(2);

        stackOfPlates.push(10);
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Integer peek = stackOfPlates.stacks.get(0).peek();
        Assert.assertEquals(Integer.valueOf(10), peek);
        stackOfPlates.push(11);
        stackOfPlates.push(12);
        Assert.assertEquals(2,stackOfPlates.stacks.size() );

        Assert.assertEquals(12,stackOfPlates.pop() );
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Assert.assertEquals(11,stackOfPlates.pop() );
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Assert.assertEquals(10,stackOfPlates.pop() );
        Assert.assertEquals(0,stackOfPlates.stacks.size() );
        Assert.assertEquals(-1,stackOfPlates.currentPointer );
        stackOfPlates.push(10);
        Assert.assertEquals(0,stackOfPlates.currentPointer );
    }

    @Test
    public void pushBookImplementationFollowUpTest() {
        SetOfStacks stackOfPlates = new SetOfStacks(2);

        stackOfPlates.push(10);
        Assert.assertEquals(1,stackOfPlates.stacks.get(0).size );
        Integer peek = stackOfPlates.stacks.get(0).bottom.value;
        Assert.assertEquals(Integer.valueOf(10), peek);
        stackOfPlates.push(11);
        stackOfPlates.push(12);
        Assert.assertEquals(2,stackOfPlates.stacks.size() );

        Assert.assertEquals(12,stackOfPlates.popAtIndex(1) );
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Assert.assertEquals(11,stackOfPlates.popAtIndex(0) );
        Assert.assertEquals(1,stackOfPlates.stacks.size() );
        Assert.assertEquals(10,stackOfPlates.popAtIndex(0) );
        Assert.assertEquals(0,stackOfPlates.stacks.size() );
        stackOfPlates.push(10);
        Assert.assertEquals(1,stackOfPlates.stacks.size() );


    }
}

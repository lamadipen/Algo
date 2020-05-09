package kata.stackqueue;

import org.junit.Assert;
import org.junit.Test;
/** Design a stack that push, pop and gives the min value in O(1)*/
public class StackMinTest {

    @Test
    public void testStackMin() {
        StackMin stackMin = new StackMin(5);

        stackMin.push(10);
        stackMin.push(8);
        Assert.assertEquals(8, stackMin.getMin());
        stackMin.push(5);
        stackMin.push(0);
        Assert.assertEquals(0, stackMin.getMin());

        stackMin.pop();
        Assert.assertEquals(5, stackMin.getMin());
        stackMin.pop();
        stackMin.pop();
        Assert.assertEquals(10, stackMin.getMin());
    }

    @Test
    public void testStackMinWithObjectOrientedApproach() {
        StackMinOOP stackMin = new StackMinOOP();

        stackMin.push(10);
        stackMin.push(8);
        Assert.assertEquals(8, stackMin.getMin());
        stackMin.push(5);
        stackMin.push(0);
        Assert.assertEquals(0, stackMin.getMin());

        stackMin.pop();
        Assert.assertEquals(5, stackMin.getMin());
        stackMin.pop();
        stackMin.pop();
        Assert.assertEquals(10, stackMin.getMin());
    }

    @Test
    public void testStackMinWithTwoStackApproach() {
        StackMinTwoStack stackMin = new StackMinTwoStack();

        stackMin.push(10);
        stackMin.push(8);
        Assert.assertEquals(8, stackMin.getMin());
        stackMin.push(5);
        stackMin.push(0);
        Assert.assertEquals(0, stackMin.getMin());

        stackMin.pop();
        Assert.assertEquals(5, stackMin.getMin());
        stackMin.pop();
        stackMin.pop();
        Assert.assertEquals(10, stackMin.getMin());
    }
}

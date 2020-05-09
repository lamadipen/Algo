package kata.stackqueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/** Use Single array to implement three stack*/
public class MultiStackTest {

    @Test
    public void multiStackAddTest() {
        MultiStack multiStack = new MultiStack(2,3);
        multiStack.push(0, 1);
        multiStack.push(0, 2);
        multiStack.push(1, 3);
        multiStack.push(1, 4);
        multiStack.push(2, 6);
        multiStack.push(2, 7);

        int[] expected = {1, 2, 3, 4, 6, 7};
        int[] actual = multiStack.stack;
        Assert.assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));

        try {
            multiStack.push(0, 3);
            Assert.fail("Didn't throw exception");
        } catch (Exception exception) {
            Assert.assertEquals("Stack is full",exception.getMessage());
        }

        int actualValue = multiStack.pop(1);
        Assert.assertEquals(4,actualValue);

        int actualValue1 = multiStack.pop(0);
        Assert.assertEquals(2,actualValue1);

    }

}

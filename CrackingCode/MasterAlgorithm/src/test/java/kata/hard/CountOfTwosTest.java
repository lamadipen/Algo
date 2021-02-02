package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class CountOfTwosTest {

    @Test
    public void countNumbersOfTwosTill() {
        CountOfTwos countOfTwos = new CountOfTwos();
        int actual = countOfTwos.countNumbersOfTwosTill(20);
        Assert.assertEquals(3, actual);

        int actual1 = countOfTwos.countNumbersOfTwosTill(22);
        Assert.assertEquals(6, actual1);
    }

    @Test
    public void countNumbersOfTwosTillOptimized() {
        CountOfTwos countOfTwos = new CountOfTwos();
//        int actual = countOfTwos.countNumbersOfTwosTillOptimized(20);
//        Assert.assertEquals(3,actual);

        int actual1 = countOfTwos.countNumbersOfTwosTillOptimized(22);
        Assert.assertEquals(6, actual1);
    }
}
package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class NumberMaxTest {

    @Test
    public void maxBetween() {
        NumberMax numberMax = new NumberMax();
        int actual = numberMax.maxBetween(3, 5);
        Assert.assertEquals(5, actual);

        int actual1 = numberMax.maxBetween(5, 3);
        Assert.assertEquals(5, actual1);

    }
}
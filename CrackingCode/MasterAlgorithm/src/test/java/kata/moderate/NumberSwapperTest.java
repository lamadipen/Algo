package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class NumberSwapperTest {
    @Test
    public void canSwapInPlace() {
        NumberSwapper numberSwapper = new NumberSwapper();
        int a = 5;
        int b = 6;
        NumberSwapper.Result r = numberSwapper.swap(a, b);

        Assert.assertEquals(a, r.b);
        Assert.assertEquals(b, r.a);
    }

    @Test
    public void canSwapInPlaceBitManipulation() {
        NumberSwapper numberSwapper = new NumberSwapper();
        int a = 5;
        int b = 6;
        NumberSwapper.Result r = numberSwapper.swapBitManipulation(a, b);

        Assert.assertEquals(a, r.b);
        Assert.assertEquals(b, r.a);
    }
}
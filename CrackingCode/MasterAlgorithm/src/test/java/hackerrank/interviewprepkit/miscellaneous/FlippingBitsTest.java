package hackerrank.interviewprepkit.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

public class FlippingBitsTest {

    @Test
    public void flippingBitsTest1() {
        long actual = FlippingBits.flippingBits(2147483647);
        Assert.assertEquals(Long.parseLong("2147483648"), actual);
    }

    @Test
    public void flippingBitsTest2() {
        long actual = FlippingBits.flippingBits(1);
        Assert.assertEquals(Long.parseLong("4294967294"), actual);
    }
}
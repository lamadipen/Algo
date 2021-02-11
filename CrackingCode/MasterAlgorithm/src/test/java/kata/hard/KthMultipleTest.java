package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class KthMultipleTest {

    @Test
    public void getKthMagicNumber() {
        KthMultiple kthMultiple = new KthMultiple();

        int kthMagicNumber = kthMultiple.getKthMagicNumber(0);

        Assert.assertEquals(0, kthMagicNumber);
    }

    @Test
    public void getKthMagicNumberOptimized1() {
        KthMultiple kthMultiple = new KthMultiple();

        int kthMagicNumber = kthMultiple.getKthMagicNumberOptimized1(0);
        Assert.assertEquals(3, kthMagicNumber);

        int kthMagicNumber1 = kthMultiple.getKthMagicNumberOptimized1(3);
        Assert.assertEquals(9, kthMagicNumber1);
    }

    @Test
    public void getKthMagicNumberOptimized2() {
        KthMultiple kthMultiple = new KthMultiple();

        int kthMagicNumber = kthMultiple.getKthMagicNumberOptimized2(1);
        Assert.assertEquals(3, kthMagicNumber);

        int kthMagicNumber1 = kthMultiple.getKthMagicNumberOptimized1(3);
        Assert.assertEquals(9, kthMagicNumber1);
    }

}
package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class FactorialZerosTest {

    @Test
    public void countFactZeroTest() {
        FactorialZeros factorialZeros = new FactorialZeros();
        int actual1 = factorialZeros.countFactZero(5);
        Assert.assertEquals(1, actual1);

        int actual2 = factorialZeros.countFactZero(20);
        Assert.assertEquals(4, actual2);

        int actual3 = factorialZeros.countFactZero(100);
        Assert.assertEquals(24, actual3);

    }

    @Test
    public void countFactZeroOptimizedTest() {
        FactorialZeros factorialZeros = new FactorialZeros();
        int actual1 = factorialZeros.factorOf5ContOptimized(5);
        Assert.assertEquals(1, actual1);

        int actual2 = factorialZeros.factorOf5ContOptimized(20);
        Assert.assertEquals(4, actual2);

        int actual3 = factorialZeros.factorOf5ContOptimized(100);
        Assert.assertEquals(24, actual3);
    }
}
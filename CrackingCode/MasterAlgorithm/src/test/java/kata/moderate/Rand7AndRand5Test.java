package kata.moderate;

import org.junit.Test;

public class Rand7AndRand5Test {

    @Test
    public void rand7Test() {
        Rand7AndRand5 rand7AndRand5 = new Rand7AndRand5();
        int actual = rand7AndRand5.rand7();

        System.out.println(actual);
    }
}
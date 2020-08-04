package kata.recursiondynamicprogramming;

import org.junit.Test;

public class CoinsTest {

    @Test
    public void makeChangeTest() {
        Coins coins = new Coins();

        int actual = coins.makeChange(10, new int[]{25, 10, 5, 1}, 0);

        System.out.println(actual);
    }


    @Test
    public void makeChangeTest2() {
        Coins coins = new Coins();

        int actual = coins.makeChange(10, new int[]{5, 1}, 0);

        System.out.println(actual);
    }

    @Test
    public void makeChangeOptimizedTest() {
        Coins coins = new Coins();
        int[][] cache = new int[11][11];

        int actual = coins.makeChangeOptimized(10, new int[]{25, 10, 5, 1}, 0, cache);
        System.out.println(actual);
    }

}
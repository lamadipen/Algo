package kata.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ShuffleTest {

    @Test
    public void randomGen() {
        Shuffle shuffle = new Shuffle();

        for (int i = 0; i < 100; i++) {
            int result = shuffle.randomGen(0, 3);
            System.out.println("result = " + result);
        }
    }


    @Test
    public void shuffleArrayRecursivelyTest() {
        Shuffle shuffle = new Shuffle();

        int[] cards = generateCards();
        int[] expected = cards.clone();

        int[] actual = shuffle.shuffleArrayRecursively(cards, 52);

        Assert.assertTrue(actual.length == expected.length);
        Assert.assertFalse(Arrays.equals(expected, actual));

        for (int i = 0; i < actual.length; i++) {
            System.out.println("actual = " + actual[i]);
        }

    }

    private int[] generateCards() {
        int[] cards = new int[53];
        for (int i = 0; i < 53; i++) {
            cards[i] = i;
        }
        return cards;
    }

    @Test
    public void shuffleArrayIterativeTest() {
        Shuffle shuffle = new Shuffle();

        int[] cards = generateCards();
        int[] expected = cards.clone();

        int[] actual = shuffle.shuffleArrayIterative(cards);

        Assert.assertTrue(actual.length == expected.length);
        Assert.assertFalse(Arrays.equals(expected, actual));

        for (int i = 0; i < actual.length; i++) {
            System.out.println("actual = " + actual[i]);
        }

    }
}
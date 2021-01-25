package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class RandomSetTest {

    private RandomSet randomSet = new RandomSet();

    @Test
    public void pickRandomSetRecursive() {
        int setSize = 7;
        int[] actual = randomSet.pickRandomSetRecursive(generateSet(setSize), 3, setSize - 1);
        Assert.assertEquals(3, actual.length);
        printArray(actual);
    }

    @Test
    public void pickRandomSetIterative() {
        int setSize = 7;
        int[] actual = randomSet.pickRandomSetIterative(generateSet(setSize), 3);
        Assert.assertEquals(3, actual.length);
        printArray(actual);
    }

    private void printArray(int[] actual) {
        for (int value : actual) {
            System.out.println("value = " + value);
        }
    }

    private int[] generateSet(int setSize) {
        int[] sourceSet = new int[setSize];
        for (int i = 0; i < setSize; i++) {
            sourceSet[i] = i;
        }
        return sourceSet;
    }
}


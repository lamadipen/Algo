package kata.hard;

import java.util.Arrays;

/**
 * Hard
 * Random set
 * CC: pg 186 Q: 17.3
 */
public class RandomSet {

    public int[] pickRandomSetRecursive(int[] src, int setSize, int index) {
        if (index + 1 == setSize) {
            return Arrays.copyOf(src, setSize);
        } else if (index + 1 > setSize) {
            int[] subset = pickRandomSetRecursive(src, setSize, index - 1);

            int randIndex = randomGen(0, index);

            if (randIndex < setSize) {
                subset[randIndex] = src[index];
            }
            return subset;
        }
        return null;
    }

    public int[] pickRandomSetIterative(int[] src, int setSize) {
        int[] subset = new int[setSize];

        for (int i = 0; i < setSize; i++) {
            subset[i] = src[i];
        }

        for (int index = setSize; index < src.length; index++) {
            int randIndex = randomGen(0, index);
            if (randIndex < setSize) {
                subset[randIndex] = src[index];
            }
        }
        return subset;
    }

    public int randomGen(int low, int high) {
        return low + (int) (Math.random() * (high - low + 1));
    }
}

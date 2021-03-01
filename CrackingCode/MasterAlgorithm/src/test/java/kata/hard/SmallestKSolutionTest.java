package kata.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestKSolutionTest {

    @Test
    public void smallestK() {
        SmallestKSolution smallestKSolution = new SmallestKSolution();
        int[] actual = smallestKSolution.smallestK(buildInputArray(), 3);
        Assert.assertArrayEquals(buildExpectedArray(), actual);
    }

    @Test
    public void smallestKMaxHeap() {
        SmallestKSolution smallestKSolution = new SmallestKSolution();
        int[] actual = smallestKSolution.smallestK(buildInputArray(), 3);
        Assert.assertArrayEquals(buildExpectedArray(), actual);
    }

    @Test
    public void smallestKSelectionRank() {
        SmallestKSolution smallestKSolution = new SmallestKSolution();
        int[] actual = smallestKSolution.smallestKSelectionRank(buildInputArray(), 3);
        Assert.assertArrayEquals(buildExpectedArray(), actual);
    }

    private int[] buildExpectedArray() {
        return new int[]{2, 3, 4};
    }

    private int[] buildInputArray() {
        return new int[]{10, 2, 3, 4, 6, 8, 7};
    }
}
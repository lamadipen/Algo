package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class MissingTwoSolutionTest {

    @Test
    public void findMissingOneNumberProductTest() {
        MissingTwoSolution missingTwoSolution = new MissingTwoSolution();
        int missingNumber = missingTwoSolution.findMissingOneNumberWithProduct(new int[]{1, 3, 4, 5});

        Assert.assertEquals(2, missingNumber);
    }

    @Test
    public void findMissingOneNumberSumTest() {
        MissingTwoSolution missingTwoSolution = new MissingTwoSolution();
        int missingNumber = missingTwoSolution.findMissingOneNumberWithSum(new int[]{1, 3, 4, 5});

        Assert.assertEquals(2, missingNumber);
    }

    @Test
    public void findMissingTowNumberSumTest() {
        MissingTwoSolution missingTwoSolution = new MissingTwoSolution();
        int[] missingNumbers = missingTwoSolution.findMissingTwoNumberWithSum(new int[]{1, 3, 4, 5, 7});

        Assert.assertEquals(2, missingNumbers[1]);
        Assert.assertEquals(6, missingNumbers[0]);
    }
}
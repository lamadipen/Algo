package kata.sortingandsearching.sortedMatrixSearch.optimized;

import org.junit.Assert;
import org.junit.Test;

public class SortedMatrixSearchSolution2Test {

    @Test
    public void sortedMatrixSearchSolution1Test() throws CloneNotSupportedException {
        int[][] matrix = new int[][]
                {
                        {1, 2, 3},
                        {5, 6, 7},
                        {8, 9, 10}
                };

        SortedMatrixSearchSolution2 solution2 = new SortedMatrixSearchSolution2();

        boolean actual = solution2.search(matrix, 6);

        Assert.assertTrue(actual);
    }

    @Test
    public void sortedMatrixSearchSolution1TargetNotFoundTest() throws CloneNotSupportedException {
        int[][] matrix = new int[][]
                {
                        {1, 2, 3},
                        {5, 6, 7},
                        {8, 9, 10}
                };

        SortedMatrixSearchSolution2 solution2 = new SortedMatrixSearchSolution2();

        boolean actual = solution2.search(matrix, 4);

        Assert.assertFalse(actual);
    }

}
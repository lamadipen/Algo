package kata.sortingandsearching.sortedMatrixSearch;

import org.junit.Assert;
import org.junit.Test;

public class SortedMatrixSearchSolutionTest {

    @Test
    public void sortedMatrixSearchSolution1Test() {
        int[][] matrix = new int[][]
                {
                        {1, 2, 3},
                        {5, 6, 7},
                        {8, 9, 10}
                };

        SortedMatrixSearchSolution1 solution1 = new SortedMatrixSearchSolution1();

        boolean actual = solution1.search(matrix, 6);

        Assert.assertTrue(actual);
    }
}
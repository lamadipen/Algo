package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class MaxBlackSquareTest {

    @Test
    public void findMaxSquareTest() {
        MaxBlackSquare maxBlackSquare = new MaxBlackSquare();
        int[][] matrix = new int[][]{
                {1, 1, 0},
                {0, 0, 1},
                {0, 0, 0}};

        SubSquare maxSquare = maxBlackSquare.findMaxSquare(matrix);

        Assert.assertEquals(maxSquare.row, 1);
        Assert.assertEquals(maxSquare.col, 0);
        Assert.assertEquals(maxSquare.size, 2);
    }


    @Test
    public void findMaxSquareOptimizedTest() {
        MaxBlackSquare maxBlackSquare = new MaxBlackSquare();
        int[][] matrix = new int[][]{
                {1, 1, 0},
                {0, 0, 1},
                {0, 0, 0}};

        SubSquare maxSquare = maxBlackSquare.findMaxSquareOptimized(matrix);

        Assert.assertEquals(maxSquare.row, 1);
        Assert.assertEquals(maxSquare.col, 0);
        Assert.assertEquals(maxSquare.size, 2);
    }
}

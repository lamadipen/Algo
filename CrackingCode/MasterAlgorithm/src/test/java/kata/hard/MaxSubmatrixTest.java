package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubmatrixTest {

    @Test
    public void getMaxMatrix() {
        MaxSubmatrix maxSubmatrix = new MaxSubmatrix();
        int[][] matrix = {
                {-1, 2, 3},
                {-2, 0, 1},
                {-3, -4, 4}};
        SubMatrix maxMatrix = maxSubmatrix.getMaxMatrix(matrix);

        Assert.assertEquals(0, maxMatrix.row1);
        Assert.assertEquals(1, maxMatrix.row2);

        Assert.assertEquals(1, maxMatrix.col1);
        Assert.assertEquals(2, maxMatrix.col2);
    }

    @Test
    public void getMaxMatrixDebug() {
        MaxSubmatrix maxSubmatrix = new MaxSubmatrix();
        int[][] matrix = {
                {2, 3},
                {0, 1}};
        SubMatrix maxMatrix = maxSubmatrix.getMaxMatrix(matrix);

        Assert.assertEquals(0, maxMatrix.row1);
        Assert.assertEquals(0, maxMatrix.col1);

        Assert.assertEquals(1, maxMatrix.row2);
        Assert.assertEquals(1, maxMatrix.col2);
    }

    @Test
    public void getMaxMatrixOptimziedTest() {
        MaxSubmatrix maxSubmatrix = new MaxSubmatrix();
        int[][] matrix = {
                {-1, 2, 3},
                {-2, 0, 1},
                {-3, -4, 4}};
        SubMatrix maxMatrix = maxSubmatrix.getMaxMatrixOptimized(matrix);

        Assert.assertEquals(0, maxMatrix.row1);
        Assert.assertEquals(2, maxMatrix.row2);

        Assert.assertEquals(2, maxMatrix.col1);
        Assert.assertEquals(2, maxMatrix.col2);
    }
}
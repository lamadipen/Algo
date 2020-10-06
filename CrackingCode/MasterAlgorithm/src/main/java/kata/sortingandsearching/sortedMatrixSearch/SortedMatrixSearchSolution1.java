package kata.sortingandsearching.sortedMatrixSearch;

/**
 * Check Sorting and Searching:
 * Sorted Matrix Search
 * CC: pg 151 Q: 10.9
 * <p>
 * Runtime mlog(n) where m => number of row and n => number of column
 */
public class SortedMatrixSearchSolution1 {
    public boolean search(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}

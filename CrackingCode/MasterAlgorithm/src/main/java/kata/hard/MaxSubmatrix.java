package kata.hard;

/**
 * Hard
 * Max Submatrix
 * CC: pg 190 Q: 17.24
 */
public class MaxSubmatrix {
    /**
     * Runtime O(n^6)
     *
     * @param matrix
     * @return
     */
    public SubMatrix getMaxMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        SubMatrix best = null;

        for (int row1 = 0; row1 < rowLength; row1++) {
            for (int row2 = row1; row2 < rowLength; row2++) {
                for (int col1 = 0; col1 < colLength; col1++) {
                    for (int col2 = col1; col2 < colLength; col2++) {
                        int sum = sum(matrix, row1, col1, row2, col2);
                        if (best == null || best.sum < sum) {
                            best = new SubMatrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }
        return best;
    }

    private int sum(int[][] matrix, int row1, int row2, int col1, int col2) {
        int sum = 0;
        for (int r = row1; r < row2; r++) {
            for (int c = col1; c < col2; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }

    /**
     * Runtime O(n^3 C)
     *
     * @param matrix
     * @return
     */
    public SubMatrix getMaxMatrixOptimized(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        SubMatrix best = null;

        for (int rowStart = 0; rowStart < rowCount; rowStart++) {
            int[] partialSum = new int[colCount];
            for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
                for (int i = 0; i < colCount; i++) {
                    partialSum[i] += matrix[rowEnd][i];
                }
                SubMatrixRange bestRange = getMaxRange(partialSum, colCount);
                if (best == null || best.sum < bestRange.sum) {
                    best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum);
                }
            }
        }
        return best;
    }

    private SubMatrixRange getMaxRange(int[] partialSum, int colCount) {
        int start = 0;
        int sum = 0;
        SubMatrixRange best = null;

        for (int i = 0; i < colCount; i++) {
            sum += partialSum[i];

            if (best == null || best.sum < sum) {
                best = new SubMatrixRange(start, i, sum);
            }

            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return best;
    }
}

class SubMatrix {
    int row1, row2, col1, col2, sum;

    public SubMatrix(int row1, int row2, int col1, int col2, int sum) {
        this.row1 = row1;
        this.row2 = row2;
        this.col1 = col1;
        this.col2 = col2;
        this.sum = sum;
    }
}

class SubMatrixRange {
    int start;
    int end;
    int sum;

    public SubMatrixRange(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}
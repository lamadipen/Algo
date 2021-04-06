package kata.hard;


/**
 * Hard
 * Max Black Square
 * CC: pg 190 Q: 17.23
 */
public class MaxBlackSquare {

    /**
     * Runtime O(n^4)
     *
     * @param matrix
     * @return
     */
    public SubSquare findMaxSquare(int[][] matrix) {
        for (int i = matrix.length; i >= 1; i--) {
            SubSquare sq = findMaxSquare(matrix, i);
            if (sq != null) {
                return sq;
            }
        }
        return null;
    }

    private SubSquare findMaxSquare(int[][] matrix, int size) {
        int noOfSquare = matrix.length - size + 1;
        for (int row = 0; row < noOfSquare; row++) {
            for (int col = 0; col < noOfSquare; col++) {
                if (isSquare(matrix, row, col, size)) {
                    return new SubSquare(row, col, size);
                }
            }
        }
        return null;
    }

    private boolean isSquare(int[][] matrix, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            if (matrix[row][col + i] == 1) {
                return false;
            }
            if (matrix[row + size - 1][col + i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (matrix[row + i][col] == 1) {
                return false;
            }
            if (matrix[row + i][col + size - 1] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runtime O(n^3)
     *
     * @param matrix
     * @return
     */
    public SubSquare findMaxSquareOptimized(int[][] matrix) {
        SquareCell[][] processedSquare = processSquare(matrix);
        for (int i = matrix.length; i >= 1; i--) {
            SubSquare sb = findSquareWithSize(processedSquare, i);
            if (sb != null) {
                return sb;
            }
        }
        return null;
    }

    private SubSquare findSquareWithSize(SquareCell[][] processedSquare, int size) {
        int noOfSquare = processedSquare.length - size + 1;
        for (int row = 0; row < noOfSquare; row++) {
            for (int col = 0; col < noOfSquare; col++) {
                if (isSquareOptimized(processedSquare, row, col, size)) {
                    return new SubSquare(row, col, size);
                }
            }
        }
        return null;
    }

    private boolean isSquareOptimized(SquareCell[][] processedSquare, int row, int col, int size) {
        SquareCell topLeft = processedSquare[row][col];
        SquareCell topRight = processedSquare[row][col + size - 1];
        SquareCell bottomLeft = processedSquare[row + size - 1][col];

        if (topLeft.zerosRight < size || topLeft.zerosBelow < size
                || topRight.zerosBelow < size || bottomLeft.zerosRight < size
        ) {
            return false;
        }
        return true;
    }

    private SquareCell[][] processSquare(int[][] matrix) {
        SquareCell[][] squareCells = new SquareCell[matrix.length][matrix.length];

        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix.length - 1; c >= 0; c--) {
                int rightZeros = 0;
                int belowZeros = 0;

                if (matrix[r][c] == 0) {
                    rightZeros++;
                    belowZeros++;

                    //next colum over the same row
                    if (c + 1 < matrix.length) {
                        SquareCell previous = squareCells[r][c + 1];
                        rightZeros += previous.zerosRight;
                    }

                    if (r + 1 < matrix.length) {
                        SquareCell previous = squareCells[r + 1][c];
                        belowZeros += previous.zerosBelow;
                    }
                }
                squareCells[r][c] = new SquareCell(rightZeros, belowZeros);
            }
        }
        return squareCells;
    }
}


class SubSquare {
    int row;
    int col;
    int size;

    public SubSquare(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
    }
}

class SquareCell {
    int zerosRight = 0;
    int zerosBelow = 0;

    public SquareCell(int zerosRight, int zerosBelow) {
        this.zerosRight = zerosRight;
        this.zerosBelow = zerosBelow;
    }
}
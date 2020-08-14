package kata.recursiondynamicprogramming;

import java.util.List;

/**
 * Recursion and dynamic programming
 * Eight Queens
 * CC: pg 136 Q: 8.12
 */
public class EightQueens {

    int GRID_SIZE = 8;

    public void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    private boolean checkValid(Integer[] columns, int row1, int col1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];

            if (col1 == col2) {
                return false;
            }

            int colDistance = Math.abs(col2 - col1);

            int rowDistance = row1 - row2;

            if (colDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }
}

package kata.recursiondynamicprogramming;

import java.util.ArrayList;

/**
 * Recursion and dynamic programming
 * RobotInGrid
 * CC: pg 135 Q: 8.2
 */
public class RobotInGrid {
    public ArrayList<Point> getPath(boolean[][] matrix) {
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(matrix, matrix.length - 1, matrix[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] matrix, int row, int col, ArrayList<Point> path) {
        if (row < 0 || col < 0 || !matrix[row][col]) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPath(matrix, row, col - 1, path) || getPath(matrix, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
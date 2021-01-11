package kata.moderate.langtonsant;

public class Grid {
    boolean[][] grid = new boolean[1][1];
    Ant ant = new Ant();

    public void printKGrid(int k) {
        while (k > 0) {
            moveAnt();
            k--;
        }
        System.out.println(toString());
    }

    public void moveAnt() {
        ant.turn(grid[ant.position.row][ant.position.col]);
        flip(ant.position);
        ant.move();
        ensureFit(ant.position); //grow the grid if needed
    }

    private void ensureFit(Position position) {
        int shiftRow = 0;
        int shiftCol = 0;

        /*calculate new number of rows*/
        int numRows = grid.length;
        if (position.row < 0) {
            shiftRow = numRows;
            numRows *= 2;
        } else if (position.row >= numRows) {
            numRows *= 2;
        }
        /*calculate new number of cols*/
        int numCols = grid[0].length;
        if (position.col < 0) {
            shiftCol = numCols;
            numCols *= 2;
        } else if (position.col >= numCols) {
            numCols *= 2;
        }

        /*Grow the array if necessary and shift ant position*/
        if (numRows != grid.length || numCols != grid[0].length) {
            boolean[][] newGrid = new boolean[numRows][numCols];
            copyWithShift(grid, newGrid, shiftRow, shiftCol);
            ant.adjustPosition(shiftRow, shiftCol);
            grid = newGrid;
        }
    }

    private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftCol) {
        for (int r = 0; r < oldGrid.length; r++) {
            for (int c = 0; c < oldGrid[0].length; c++) {
                newGrid[r + shiftRow][c + shiftCol] = oldGrid[r][c];
            }
        }
    }

    private void flip(Position position) {
        int row = position.row;
        int col = position.col;

        grid[row][col] = grid[row][col] ? false : true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r == ant.position.row && c == ant.position.col) {
                    sb.append(ant.orientation);
                } else if (grid[r][c]) {
                    sb.append("B");
                } else {
                    sb.append("W");
                }
            }
            sb.append("\n");
        }
        sb.append("Ant: " + ant.orientation + "\n");
        return sb.toString();
    }
}

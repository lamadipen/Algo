package kata.sortingandsearching.sortedMatrixSearch.optimized;

public class Coordinate implements Cloneable {
    int row, col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean inbound(int[][] matrix) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
    }

    public boolean isBefore(Coordinate destination) {
        return row <= destination.row && col <= destination.col;
    }

    public void setToAverage(Coordinate src, Coordinate des) {
        row = (src.row + des.row) / 2;
        col = (src.col + des.col) / 2;
    }

    public Object clone() throws CloneNotSupportedException {
        return new Coordinate(row, col);
    }
}

package kata.sortingandsearching.sortedMatrixSearch.optimized;


/**
 * Check Sorting and Searching:
 * Sorted Matrix Search
 * CC: pg 151 Q: 10.9
 * <p>
 * Runtime log(n) where n => number of column
 */
public class SortedMatrixSearchSolution2 {
    public boolean search(int[][] matrix, int target) throws CloneNotSupportedException {
        Coordinate src = new Coordinate(0, 0);
        Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
        Coordinate search = search(matrix, src, dest, target);

        return search == null ? false : true;
    }

    private Coordinate search(int[][] matrix, Coordinate src, Coordinate dest, int target) throws CloneNotSupportedException {
        if (!src.inbound(matrix) && !dest.inbound(matrix)) {
            return null;
        }
        if (matrix[src.row][src.col] == target) {
            return src;
        } else if (!src.isBefore(dest)) {
            return null;
        }

        Coordinate start = (Coordinate) src.clone();
        int diagonal = Math.min(dest.row - src.row, dest.col - src.col);
        Coordinate end = new Coordinate(src.row + diagonal, src.col + diagonal);
        Coordinate p = new Coordinate(0, 0);

        while (start.isBefore(end)) {
            p.setToAverage(start, end);
            if (target > matrix[p.row][p.col]) {
                start.row = p.row + 1;
                start.col = p.col + 1;
            } else {
                end.row = p.row - 1;
                end.col = p.col - 1;
            }
        }
        return parationAndSearch(matrix, src, dest, start, target);
    }

    private Coordinate parationAndSearch(int[][] matrix, Coordinate src, Coordinate dest, Coordinate pivot, int target) throws CloneNotSupportedException {
        Coordinate lowerLeftOrigin = new Coordinate(pivot.row, src.col);
        Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.col - 1);
        Coordinate upperRightOrigin = new Coordinate(src.row, pivot.col);
        Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.col);

        Coordinate lowerLeft = search(matrix, lowerLeftOrigin, lowerLeftDest, target);
        if (lowerLeft == null) {
            return search(matrix, upperRightOrigin, upperRightDest, target);
        }
        return lowerLeft;
    }


}

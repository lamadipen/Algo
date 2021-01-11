package kata.moderate.langtonsant;

import java.util.HashSet;
import java.util.Set;

public class GridWithSet {
    Set<Position> whites = new HashSet<>();
    Ant ant = new Ant();
    Position topLeftCorner = new Position(0, 0);
    Position bottomRightCorner = new Position(0, 0);

    public void moveAnt() {
        ant.turn(isWhite(ant.position));
        flip(ant.position);
        ant.move();
        ensureFit(ant.position);
    }

    private void ensureFit(Position position) {
        int row = position.row;
        int col = position.col;

        topLeftCorner.row = Math.min(row, topLeftCorner.row);
        topLeftCorner.col = Math.min(col, topLeftCorner.col);

        bottomRightCorner.row = Math.max(row, bottomRightCorner.row);
        bottomRightCorner.col = Math.max(col, bottomRightCorner.col);
    }

    private void flip(Position position) {
        if (whites.contains(position)) {
            whites.remove(position);
        } else {
            whites.add(position.clone());
        }
    }

    private boolean isWhite(Position position) {
        return whites.contains(position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rowMin = topLeftCorner.row;
        int colMin = topLeftCorner.col;

        int rowMax = bottomRightCorner.row;
        int colMax = bottomRightCorner.col;

        for (int r = rowMin; r <= rowMax; r++) {
            for (int c = colMin; c <= colMax; c++) {
                if (ant.position.equals(new Position(r, c))) {
                    sb.append(ant.orientation);
                } else if (isWhite(r, c)) {
                    sb.append('W');
                } else {
                    sb.append('B');
                }
            }
            sb.append("\n");
        }
        sb.append("Ant: " + ant.orientation + "\n");
        return sb.toString();
    }

    private boolean isWhite(int r, int c) {
        return whites.contains(new Position(r, c));
    }

    public void printKGrid(int k) {
        while (k > 0) {
            moveAnt();
            k--;
        }
        System.out.println(toString());
    }
}

package kata.moderate;

import java.util.ArrayList;
import java.util.List;

/**
 * Moderate
 * Pond Sizes
 * CC: pg 184 Q: 16.19
 */
public class PondSizes {

    public List<Integer> computePondSize(int[][] map) {
        List<Integer> result = new ArrayList<>();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 0) {
                    int size = computeSize(map, row, col);
                    result.add(size);
                }
            }
        }
        return result;
    }

    private int computeSize(int[][] map, int row, int col) {
        if (row < 0 || col < 0 ||
                row >= map.length || col >= map[0].length ||
                map[row][col] != 0
        ) {
            return 0;
        }
        int size = 1;
        map[row][col] = -1;

        for (int drow = -1; drow <= 1; drow++) {
            for (int dcol = -1; dcol <= 1; dcol++) {
                size += computeSize(map, row + drow, col + dcol);
            }
        }
        return size;
    }
}

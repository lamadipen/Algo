package hackerrank.interviewprepkit.stacksandqueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Interview Preparation Kit | Stacks and Queues | Castle on the Grid
 */
public class CastleOnTheGridSolution {


    /**
     * . . .
     * . x .
     * . . .
     */
    static final int[] X_OFFSETS = {-1, 0, 1, 0};
    static final int[] Y_OFFSETS = {0, 1, 0, -1};

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        char[][] charGrid = IntStream
                .range(0, grid.size())
                .mapToObj(index -> grid.get(index).toCharArray())
                .toArray(char[][]::new);

        return minimumMovesChar(charGrid, startX, startY, goalX, goalY);
    }

    /**
     * https://github.com/charles-wangkai/hackerrank
     * https://github.com/charles-wangkai/hackerrank/blob/master/castle-on-the-grid/Solution.java
     */
    private static int minimumMovesChar(char[][] grid, int startX, int startY, int goalX, int goalY) {
        if (startX == goalX && startY == goalY) {
            return 0;
        }

        int inputSize = grid.length;
        int[][] moves = new int[inputSize][inputSize];
        IntStream
                .range(0, inputSize)
                .forEach(item -> Arrays.fill(moves[item], -1));

        moves[startX][startY] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));

        while (true) {
            Point head = queue.poll();
            for (int i = 0; i < X_OFFSETS.length; i++) {
                int nextX = head.x;
                int nextY = head.y;

                while (isOpen(grid, nextX + X_OFFSETS[i], nextY + Y_OFFSETS[i])) {
                    nextX += X_OFFSETS[i];
                    nextY += Y_OFFSETS[i];

                    if (nextX == goalX && nextY == goalY) {
                        return moves[head.x][head.y] + 1;
                    }

                    if (moves[nextX][nextY] < 0) {
                        moves[nextX][nextY] = moves[head.x][head.y] + 1;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    private static boolean isOpen(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == '.';
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

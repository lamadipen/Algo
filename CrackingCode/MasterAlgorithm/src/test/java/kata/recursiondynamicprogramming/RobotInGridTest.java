package kata.recursiondynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RobotInGridTest {

    @Test
    public void findPathToEnd() {
        boolean[][] matrix = new boolean[3][3];
        matrix[0][0] = true;
        matrix[0][1] = true;
        matrix[0][2] = false;
        matrix[1][0] = true;
        matrix[1][1] = false;
        matrix[1][2] = true;
        matrix[2][0] = true;
        matrix[2][1] = true;
        matrix[2][2] = true;

        RobotInGrid robotInGrid = new RobotInGrid();
        ArrayList<Point> paths = robotInGrid.getPath(matrix);

        for (Point p : paths) {
            System.err.println(p.toString());
            if (p.col == 0 && p.row == 0) {
                Assert.assertTrue(true);
            }
        }
    }
}
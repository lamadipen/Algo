package hackerrank.interviewprepkit.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CastleOnTheGridSolutionTest {

    @Test
    public void minimumMovesTest_while_start_and_end_same() {
        List<String> grid = new ArrayList<>();
        grid.add(".X.");
        grid.add(".X.");
        grid.add("...");
        int actual = CastleOnTheGridSolution.minimumMoves(grid, 0, 0, 0, 2);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void minimumMovesTest() {
        List<String> grid = new ArrayList<>();
        grid.add(".X.");
        grid.add(".X.");
        grid.add("...");
        int actual = CastleOnTheGridSolution.minimumMoves(grid, 0, 0, 0, 2);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void convertListOfStringToTwoDimensionArray() {
        List<String> grid = new ArrayList<>();
        grid.add(".X.");
        grid.add(".X.");
        grid.add("...");

        char[][] chars = IntStream
                .range(0, 3)
                .mapToObj(index -> grid.get(index).toCharArray())
                .toArray(char[][]::new);
    }
}

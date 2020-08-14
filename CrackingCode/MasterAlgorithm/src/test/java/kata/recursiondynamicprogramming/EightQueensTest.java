package kata.recursiondynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueensTest {

    @Test
    public void placeQueensTest() {
        EightQueens eightQueens = new EightQueens();

        ArrayList<Integer[]> result = new ArrayList<>();
        eightQueens.placeQueens(0, new Integer[8], result);

        result
                .forEach(arr ->
                        System.out.println(Arrays.toString(arr))
                );
    }

}
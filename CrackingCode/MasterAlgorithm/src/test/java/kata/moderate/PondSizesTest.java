package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class PondSizesTest {

    @Test
    public void computePondSizeTest() {
        PondSizes pondSizes = new PondSizes();

        int[][] map = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        List<Integer> result = pondSizes.computePondSize(map);

        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());

        List<Integer> sortedResult = result
                .stream()
                .sorted()
                .collect(Collectors.toList());

        for (int size : sortedResult) {
            System.out.println(size);
        }

    }

}
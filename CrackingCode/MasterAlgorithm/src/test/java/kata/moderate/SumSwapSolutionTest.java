package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class SumSwapSolutionTest {

    @Test
    public void findSwapValues() {
        SumSwapSolution sumSwapSolution = new SumSwapSolution();

        int[] swapValues = sumSwapSolution.findSwapValues(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});

        Assert.assertEquals(4, swapValues[0]);
        Assert.assertEquals(6, swapValues[1]);
    }

    @Test
    public void findSwapValuesTargetApproach() {
        SumSwapSolution sumSwapSolution = new SumSwapSolution();

        int[] swapValues = sumSwapSolution.findSwapValuesTargetApproach(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});

        Assert.assertEquals(4, swapValues[0]);
        Assert.assertEquals(6, swapValues[1]);
    }

    @Test
    public void findSwapValuesTargetOptimized() {
        SumSwapSolution sumSwapSolution = new SumSwapSolution();

        int[] swapValues = sumSwapSolution.findSwapValuesTargetOptimized(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});

        Assert.assertEquals(4, swapValues[0]);
        Assert.assertEquals(6, swapValues[1]);
    }

    @Test
    public void findSwapValuesTargetOptimizedNoExtraSpaceRequired() {
        SumSwapSolution sumSwapSolution = new SumSwapSolution();

        int[] swapValues = sumSwapSolution.findSwapValuesTargetOptimizedNoExtraSpaceRequired(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});

        Assert.assertEquals(1, swapValues[0]);
        Assert.assertEquals(3, swapValues[1]);
    }
}
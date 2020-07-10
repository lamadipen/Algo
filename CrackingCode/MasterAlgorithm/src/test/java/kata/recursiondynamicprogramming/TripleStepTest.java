package kata.recursiondynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class TripleStepTest {

    @Test
    public void calculateWaysOne() {
        TripleStep tripleStep = new TripleStep();
        int actual = tripleStep.calculateWays(10);
        Assert.assertEquals(274, actual);
    }

    @Test
    public void calculateWaysTwo() {
        TripleStep tripleStep = new TripleStep();
        int actual = tripleStep.calculateWays(4);
        Assert.assertEquals(7, actual);
    }

    @Test
    public void calculateWaysDynamicProgramming() {
        TripleStep tripleStep = new TripleStep();
        int actual = tripleStep.calculateWaysMemoization(4);
        Assert.assertEquals(7, actual);
    }

    @Test
    public void calculateWaysDynamicProgramming3() {
        TripleStep tripleStep = new TripleStep();
        int actual = tripleStep.calculateWays(3);
        Assert.assertEquals(4, actual);
    }


}
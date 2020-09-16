package kata.recursiondynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class BooleanEvaluationTest {

    @Test
    public void countEvalTest() {
        BooleanEvaluation booleanEvaluation = new BooleanEvaluation();
        int actual = booleanEvaluation.countEval("1^0|0|1", false);
        Assert.assertEquals(2, actual);

        //int actual1 = booleanEvaluation.countEval("0&0&0&1^1|0", true);
        //Assert.assertEquals(10, actual1);

        System.err.println(0 ^ 1);
    }
}
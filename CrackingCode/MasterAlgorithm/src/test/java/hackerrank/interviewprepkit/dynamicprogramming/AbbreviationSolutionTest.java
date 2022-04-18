package hackerrank.interviewprepkit.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class AbbreviationSolutionTest {

    @Test
    public void abbreviationTest1() {
        String actual = AbbreviationSolution.abbreviationSimpleSolution("daBcd", "ABC");
        Assert.assertEquals("YES", actual);
    }

    @Test
    public void abbreviationSimpleSolutionTest1() {
        String actual = AbbreviationSolution.abbreviationSimpleSolution("LDJAN", "LJJM");
        Assert.assertEquals("YES", actual);
    }
}
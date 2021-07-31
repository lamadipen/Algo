package hackerrank.interviewprepkit.stringmanipulation;

import org.junit.Assert;
import org.junit.Test;

public class SpecialStringAgainSolutionTest {

    @Test
    public void substrCountTest1() {
        long actual = SpecialStringAgainSolution.substrCount(5, "asasd");
        Assert.assertEquals(7, actual);
    }

    @Test
    public void substrCountTest2() {
        long actual = SpecialStringAgainSolution.substrCount(7, "abcbaba");
        Assert.assertEquals(10, actual);
    }

    @Test
    public void substrCountTest3() {
        long actual = SpecialStringAgainSolution.substrCount(4, "aaaa");
        Assert.assertEquals(10, actual);
    }

    @Test
    public void substrCountTest4() {
        long actual = SpecialStringAgainSolution.substrCount(3, "aaa");
        Assert.assertEquals(6, actual);
    }

    @Test
    public void substrCountTest5() {
        long actual = SpecialStringAgainSolution.substrCount(4, "abab");
        Assert.assertEquals(6, actual);
    }


    @Test
    public void substrCountTest6() {
        long actual = SpecialStringAgainSolution.substrCount(8, "mnonopoo");
        Assert.assertEquals(12, actual);
    }

    @Test
    public void substrCountTest7() {
        long actual = SpecialStringAgainSolution.substrCount(8, "pppoppp");
        Assert.assertEquals(12, actual);
    }
}
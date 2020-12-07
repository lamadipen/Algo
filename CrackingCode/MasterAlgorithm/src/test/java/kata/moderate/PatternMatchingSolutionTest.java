package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class PatternMatchingSolutionTest {

    @Test
    public void doesMatchesTest() {
        PatternMatchingSolution patternMatchingSolution = new PatternMatchingSolution();

        boolean actual = patternMatchingSolution.doesMatches("aabab", "catcatgocatgo");

        Assert.assertTrue(actual);
    }

    @Test
    public void doesMatchesFirstOptimizationTest() {
        PatternMatchingSolution patternMatchingSolution = new PatternMatchingSolution();

        boolean actual = patternMatchingSolution.doesMatchesFirstOptimization("aabab", "catcatgocatgo");

        Assert.assertTrue(actual);
    }

    @Test
    public void doesMatchesFirstOptimizationCustomInputTest() {
        PatternMatchingSolution patternMatchingSolution = new PatternMatchingSolution();

        boolean actual = patternMatchingSolution.doesMatchesFirstOptimization("ababb", "catgocatgogo");

        Assert.assertTrue(actual);
    }
}
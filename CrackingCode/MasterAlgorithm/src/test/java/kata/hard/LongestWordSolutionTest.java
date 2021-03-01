package kata.hard;

import org.junit.Assert;
import org.junit.Test;


public class LongestWordSolutionTest {

    @Test
    public void getLongestWordTest() {
        LongestWordSolution longestWordSolution = new LongestWordSolution();
        String[] words = new String[]{"cat", "dog", "banana", "walker", "dogwalker"};
        String actual = longestWordSolution.getLongestWord(words);

        Assert.assertEquals("dogwalker", actual);
    }

    @Test
    public void getLongestWordMoreThanTwoWordsTest() {
        LongestWordSolution longestWordSolution = new LongestWordSolution();
        String[] words = new String[]{"cat", "dog", "banana", "walker", "dogwalkercat"};
        String actual = longestWordSolution.getLongestWordMoreWords(words);

        Assert.assertEquals("dogwalkercat", actual);
    }
}
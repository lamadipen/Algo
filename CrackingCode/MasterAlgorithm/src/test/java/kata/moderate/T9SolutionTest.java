package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class T9SolutionTest {
    @Test
    public void getValidWordsTest() {
        T9Solution t9Solution = new T9Solution();

        HashSet<String> words = new HashSet<>();
        words.add("tree");
        words.add("used");

        List<String> validT9Words = t9Solution.getValidT9Words("8733", words);

        Assert.assertTrue(validT9Words.size() == 2);
        Assert.assertTrue(validT9Words.contains("tree"));
        Assert.assertTrue(validT9Words.contains("used"));
    }

    @Test
    public void getValidWordsOptimizedTest() {
        T9Solution t9Solution = new T9Solution();

        HashSet<String> words = new HashSet<>();
        words.add("tree");
        words.add("used");

        t9Solution.initilizeDictionary(words);
        List<String> validT9Words = t9Solution.getValidT9WordsOptimized("8733");

        Assert.assertTrue(validT9Words.size() == 2);
        Assert.assertTrue(validT9Words.contains("tree"));
        Assert.assertTrue(validT9Words.contains("used"));
    }

}
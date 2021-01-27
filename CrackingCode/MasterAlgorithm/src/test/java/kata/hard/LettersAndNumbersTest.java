package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class LettersAndNumbersTest {

    LettersAndNumbers lettersAndNumbers = new LettersAndNumbers();

    @Test
    public void findLongestSubArray() {
        char[] longestSubArray = lettersAndNumbers.findLongestSubArray(new char[]{'a', 'b', '1', 'c', '1', '2', '3'});

        if (null != longestSubArray) {
            for (char c : longestSubArray) {
                System.out.println("c = " + c);
            }
        }
    }

    @Test
    public void findLongestSubArrayScenario2() {
        char[] longestSubArray = lettersAndNumbers.findLongestSubArray(new char[]{'a', 'b', '1', '1', '2', '3'});

        if (null != longestSubArray) {
            for (char c : longestSubArray) {
                System.out.println("c = " + c);
            }
        }
    }

    @Test
    public void findLongestSubArrayScenario3() {
        char[] longestSubArray = lettersAndNumbers.findLongestSubArray(new char[]{'a', 'b', '1', '1'});

        if (null != longestSubArray) {
            for (char c : longestSubArray) {
                System.out.println("c = " + c);
            }
        }
    }


    @Test
    public void findLongestSubArrayScenario4() {
        char[] longestSubArray = lettersAndNumbers.findLongestSubArray(new char[]{'a', '1', 'b', '1'});

        if (null != longestSubArray) {
            for (char c : longestSubArray) {
                System.out.println("c = " + c);
            }
        }
    }

    @Test
    public void findLongestSubArrayOptimizedScenario() {
        char[] longestSubArray = lettersAndNumbers.findLongestSubArrayOptimized(new char[]{'a', '1', 'b', '1'});

        if (null != longestSubArray) {
            for (char c : longestSubArray) {
                System.out.println("c = " + c);
            }
        }
    }

    @Test
    public void findLongestSubArray_bruteForce_Optimized_result_must_matchScenario() {
        char[] longestSubArrayBruteForce = lettersAndNumbers.findLongestSubArrayOptimized(new char[]{'a', '1', 'b', '1'});
        char[] longestSubArrayOptimized = lettersAndNumbers.findLongestSubArray(new char[]{'a', '1', 'b', '1'});

        Assert.assertArrayEquals(longestSubArrayBruteForce, longestSubArrayOptimized);

        if (null != longestSubArrayOptimized) {
            for (char c : longestSubArrayOptimized) {
                System.out.println("c = " + c);
            }
        }
    }
}
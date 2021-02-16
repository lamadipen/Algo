package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class WordDistanceTest {

    @Test
    public void findClosest() {
        WordDistance wordDistance = new WordDistance();

        String string = "apple is red and mango is yellow both are sweet. I will eat mango. I love red apple";

        String[] words = string.split("\\s");

        LocationPoint actual = wordDistance.findClosest(words, "apple", "red");

        Assert.assertEquals(17, actual.point1);
        Assert.assertEquals(16, actual.point2);
    }

    @Test
    public void findClosestOptimizedTest() {
        WordDistance wordDistance = new WordDistance();

        String string = "apple is red and mango is yellow both are sweet. I will eat mango. I love red apple";

        String[] words = string.split("\\s");

        wordDistance.populateLocationPairs(words);
        LocationPoint actual = wordDistance.findClosestOptimized("apple", "red");

        Assert.assertEquals(17, actual.point1);
        Assert.assertEquals(16, actual.point2);
    }
}
package kata.recursiondynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PermutationsWithoutDupsTest {

    @Test
    public void permutaionsTest() {
        PermutationsWithoutDups withoutDups = new PermutationsWithoutDups();

        List<String> actual = withoutDups.finaAllPermutaion("abc");

        for (String word : actual) {
            System.out.println(word);
        }

        Assert.assertEquals(6, actual.size());
    }

    @Test
    public void permutaionsIterativeTest() {
        PermutationsWithoutDups withoutDups = new PermutationsWithoutDups();

        List<String> actual = withoutDups.finaAllPermutaionIterative("abc");


        for (String word : actual) {
            System.out.println(word);
        }

        Assert.assertEquals(6, actual.size());
    }

}
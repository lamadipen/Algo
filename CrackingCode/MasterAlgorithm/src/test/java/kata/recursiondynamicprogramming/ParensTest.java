package kata.recursiondynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParensTest {
    @Test
    public void getParensTest() {
        Set<String> expected = new HashSet<>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");

        Parens parens = new Parens();
        Set<String> actual = parens.getParens(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getParensOptimizedTest() {
        List<String> expected = new ArrayList<>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");

        Parens parens = new Parens();
        List<String> actual = parens.getParensOptmized(3);

        Assert.assertEquals(expected, actual);
    }

}
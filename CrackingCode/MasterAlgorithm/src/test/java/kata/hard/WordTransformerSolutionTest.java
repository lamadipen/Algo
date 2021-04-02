package kata.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordTransformerSolutionTest {

    @Test
    public void transform() {
        WordTransformerSolution wordTransformerSolution = new WordTransformerSolution();
        List<String> transform = wordTransformerSolution.transform("DAMP", "LIKE", new String[]{"LAMP", "LIMP", "LIME", "LIKE", "BITE", "DAMP"});

//        String[] expected = {"DAMP", "LAMP", "LIMP", "LIME", "LIKE"};
        String[] expected = {"lamp", "limp", "lime", "like"};
        Assert.assertEquals(transform, Arrays.asList(expected));
    }

    @Test
    public void transformBFS() {
        WordTransformerSolution wordTransformerSolution = new WordTransformerSolution();
        List<String> transform = wordTransformerSolution.transformBFS("DAMP", "LIKE", new String[]{"LAMP", "LIMP", "LIME", "LIKE", "BITE", "DAMP"});

        String[] expected = {"DAMP", "LAMP", "LIMP", "LIME", "LIKE"};
        Assert.assertEquals(transform, Arrays.asList(expected));
    }
}
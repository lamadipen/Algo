package kata.hard;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MultiSearchSolutionTest {

    @Test
    public void search() {
        MultiSearchSolution searchSolution = new MultiSearchSolution();

        Map<String, List<Integer>> mississippi = searchSolution.search("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});

        System.out.println("mississippi = " + mississippi);
    }

    @Test
    public void searchWithTries() {
        MultiSearchSolution searchSolution = new MultiSearchSolution();

        Map<String, List<Integer>> mississippi = searchSolution.searchWithTries("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});

        System.out.println("mississippi = " + mississippi);
    }

    @Test
    public void searchWithTriesCustomInput() {
        MultiSearchSolution searchSolution = new MultiSearchSolution();

        Map<String, List<Integer>> mississippi = searchSolution.searchWithTries("ball", new String[]{"ba", "all", "al", "a", "ssippi"});

        System.out.println("mississippi = " + mississippi);
    }

    @Test
    public void searchWithTriesOptimized() {
        MultiSearchSolution searchSolution = new MultiSearchSolution();

        Map<String, List<Integer>> mississippi = searchSolution.searchWithTriesOptimized("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});

        System.out.println("mississippi = " + mississippi);
    }
}
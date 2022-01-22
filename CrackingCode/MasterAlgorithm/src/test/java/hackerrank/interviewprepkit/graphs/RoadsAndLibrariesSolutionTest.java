package hackerrank.interviewprepkit.graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoadsAndLibrariesSolutionTest {

    @Test
    public void roadsAndLibraries1() {
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(Arrays.asList(new Integer[]{1, 2}));
        cities.add(Arrays.asList(new Integer[]{3, 1}));
        long actual = RoadsAndLibrariesSolution.roadsAndLibraries(3, 2, 1, cities);

        Assert.assertEquals(4, actual);
    }

    @Test
    public void roadsAndLibraries2() {
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(Arrays.asList(new Integer[]{1, 3}));
        cities.add(Arrays.asList(new Integer[]{3, 4}));
        cities.add(Arrays.asList(new Integer[]{2, 4}));
        cities.add(Arrays.asList(new Integer[]{1, 2}));
        cities.add(Arrays.asList(new Integer[]{2, 3}));
        cities.add(Arrays.asList(new Integer[]{5, 6}));
        long actual = RoadsAndLibrariesSolution.roadsAndLibraries(6, 2, 5, cities);

        Assert.assertEquals(12, actual);
    }

    @Test
    public void roadsAndLibraries3() {
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(Arrays.asList(new Integer[]{1, 3}));
        cities.add(Arrays.asList(new Integer[]{3, 4}));
        cities.add(Arrays.asList(new Integer[]{2, 4}));
        cities.add(Arrays.asList(new Integer[]{1, 2}));
        cities.add(Arrays.asList(new Integer[]{2, 3}));
        cities.add(Arrays.asList(new Integer[]{5, 6}));
        long actual = RoadsAndLibrariesSolution.roadsAndLibraries(6, 2, 5, cities);

        Assert.assertEquals(12, actual);
    }

    @Test
    public void roadsAndLibraries4() {
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(Arrays.asList(new Integer[]{1, 2}));
        cities.add(Arrays.asList(new Integer[]{1, 3}));
        cities.add(Arrays.asList(new Integer[]{1, 4}));
        long actual = RoadsAndLibrariesSolution.roadsAndLibraries(5, 6, 1, cities);

        Assert.assertEquals(15, actual);
    }

    @Test
    public void roadsAndLibrariesReferenceSolution1() {
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(Arrays.asList(new Integer[]{1, 2}));
        cities.add(Arrays.asList(new Integer[]{3, 1}));
        long actual = RoadsAndLibrariesSolution.roadsAndLibrariesReferenceSolution(3, 2, 1, cities);

        Assert.assertEquals(4, actual);
    }
}
package hackerrank.interviewprepkit.graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;

public class MatrixSolutionTest {

    @Test
    public void testReference1() {
        int[][] roads = new int[][]{
                {2, 1, 8},
                {1, 0, 5},
                {2, 4, 5,},
                {1, 3, 4}
        };
        int[] machines = new int[]{2, 4, 0};
        int minTime = MatrixSolution.minTimeReference1(roads, machines);

        Assert.assertEquals(10, minTime);
    }

    @Test
    public void testReference2() {
        int[][] roads = new int[][]{
                {2, 1, 8},
                {1, 0, 5},
                {2, 4, 5,},
                {1, 3, 4}
        };
        int[] machines = new int[]{2, 4, 0};
        int minTime = MatrixSolution.minTimeReference2(roads, machines);

        Assert.assertEquals(10, minTime);
    }

    @Test
    public void test1List() {
        List<List<Integer>> roads = new ArrayList<List<Integer>>();
        roads.add(Arrays.asList(2, 1, 8));
        roads.add(Arrays.asList(1, 0, 5));
        roads.add(Arrays.asList(2, 4, 5));
        roads.add(Arrays.asList(1, 3, 4));
        List<Integer> machines = Arrays.asList(2, 4, 0);
        int minTime = MatrixSolution.minTime(roads, machines);

        Assert.assertEquals(10, minTime);
    }

    @Test
    public void test2List() {
        List<List<Integer>> roads = new ArrayList<List<Integer>>();
        roads.add(Arrays.asList(0, 1, 4));
        roads.add(Arrays.asList(1, 2, 3));
        roads.add(Arrays.asList(1, 3, 7));
        roads.add(Arrays.asList(0, 4, 2));
        List<Integer> machines = Arrays.asList(2, 3, 4);
        int minTime = MatrixSolution.minTime(roads, machines);

        Assert.assertEquals(5, minTime);
    }

    @Test
    public void test3List() {
        List<List<Integer>> roads = new ArrayList<List<Integer>>();
        roads.add(Arrays.asList(2, 1, 8));
        roads.add(Arrays.asList(1, 0, 5));
        roads.add(Arrays.asList(2, 4, 5));
        roads.add(Arrays.asList(1, 3, 4));
        List<Integer> machines = Arrays.asList(2, 4, 0);
        int minTime = MatrixSolution.minTimeListWorkingSolution2(roads, machines);

        Assert.assertEquals(10, minTime);
    }

    @Test
    public void testFind() {
        Map<Integer, Integer> parent = new HashMap<>();
        //Find by splitting
        IntFunction find = x -> {
            while (x != parent.getOrDefault(x, x)) {
                x = parent.put(x, parent.get(x));
            }
            return x;
        };

        Function<int[], Integer> union = roadArray -> {
            int node1 = (int) find.apply(roadArray[0]);
            int node2 = (int) find.apply(roadArray[1]);

            if (node1 != node2) {
                parent.put(node1, node2);
            }
            return 0;
        };

        int[][] roads = new int[][]{
                {2, 1, 8},
                {1, 0, 5},
                {2, 4, 5,},
                {1, 3, 4}
        };

        Arrays
                .stream(roads)
                .map(road -> union.apply(road))
                .reduce(0, Integer::sum);
    }

    @Test
    public void testMapPutGet() {
        Map<Integer, Integer> parent = new HashMap<>();

        Integer p1 = parent.put(1, 2);

        System.out.println("p1 = " + p1);

        Integer p2 = parent.put(1, parent.get(1));
        System.out.println("p2 = " + p2);
    }

    @Test
    public void testCompare() {
//        MatrixSolution.minTime()

//        int compare = Integer.compare(2, 1);
//        System.out.println("compare = " + compare);
    }

}
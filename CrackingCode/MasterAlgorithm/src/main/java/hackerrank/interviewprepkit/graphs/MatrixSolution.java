package hackerrank.interviewprepkit.graphs;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.stream.Stream;

/**
 * Interview Preparation Kit | Graphs | Matrix
 */

public class MatrixSolution {

    /*
     * Complete the 'minTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY roads
     *  2. INTEGER_ARRAY machines
     */

    static IntBinaryOperator dfs;

    static int minTimeListWorkingSolution2(List<List<Integer>> roads, List<Integer> machines) {
        int noOfNodes = roads.size() + 1;
        boolean[] isMachine = new boolean[noOfNodes];
        machines.forEach(m -> isMachine[m] = true);

        //Adjacency List of roads
        List<int[]>[] adj = Stream.generate(ArrayList::new).limit(noOfNodes).toArray(List[]::new);

        for (List<Integer> road : roads) {
            adj[road.get(0)].add(new int[]{road.get(1), road.get(2)});
            adj[road.get(1)].add(new int[]{road.get(0), road.get(2)});
        }

        boolean[] seen = new boolean[noOfNodes];
        final int[] total = new int[1];

        dfs = (city, time) -> {
            seen[city] = true;
            int maxTime = 0;
            int sumTime = 0;

            for (int[] neighbor : adj[city]) {
                if (seen[neighbor[0]]) continue;

                int neighborTime = dfs.applyAsInt(neighbor[0], neighbor[1]);

                sumTime += neighborTime;
                maxTime = Math.max(maxTime, neighborTime);
            }

            if (isMachine[city]) {
                total[0] += sumTime;
                return time;
            } else {
                total[0] += sumTime - maxTime;
                return Math.min(maxTime, time);
            }
        };

        dfs.applyAsInt(0, 0);
        return total[0];
    }

    public static int minTime(List<List<Integer>> roads, List<Integer> machines) {
        // Write your code here
        Collections.sort(roads, (x, y) -> Integer.compare(y.get(2), x.get(2)));
        int noOfNodes = roads.size() + 1;
        Map<Integer, Integer> parents = new HashMap<>();

        boolean[] red = new boolean[noOfNodes];

        for (int machine : machines) {
            red[machine] = true;
        }

        IntFunction find = node -> {
            if (node != parents.getOrDefault(node, node)) {
                node = parents.put(node, parents.get(node));
            }
            return node;
        };

        int[] sizes = new int[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            sizes[i] = 1;
        }

        Function<List<Integer>, Integer> union = road -> {
            int node1 = (int) find.apply(road.get(0));
            int node2 = (int) find.apply(road.get(1));

            if (red[node1] == red[node2]) return road.get(2);

            if (node1 != node2) {
                if (sizes[node1] > sizes[node2]) {
                    int temp = node1;
                    node1 = node2;
                    node2 = node1;
                }
                parents.put(node1, node2);
                sizes[node2] += sizes[node1];
            }
            red[node1] |= red[node2];
            red[node2] |= red[node1];
            return 0;
        };

        return roads
                .stream()
                .map(road -> union.apply(road))
                .reduce(0, Integer::sum);
    }

    //Java 8 Solution in O(n log(n)) with Union-Find
    static int minTimeReference1(int[][] roads, int[] machines) {
        //Sort Array in descending order
        Arrays.sort(roads, (x, y) -> Integer.compare(y[2], x[2]));

        int noOfNodes = roads.length + 1;

        Map<Integer, Integer> parent = new HashMap<>();

        boolean[] red = new boolean[noOfNodes];

        for (int machine : machines) {
            red[machine] = true;
        }

        //Find by splitting
        IntFunction find = x -> {
            while (x != parent.getOrDefault(x, x)) {
                x = parent.put(x, parent.get(x));
            }
            return x;
        };

        //Union by size
        int[] size = new int[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            size[i] = 1;
        }

        Function<int[], Integer> union = roadArray -> {
            int node1 = (int) find.apply(roadArray[0]);
            int node2 = (int) find.apply(roadArray[1]);

            if (red[node1] && red[node2]) return roadArray[2];

            if (node1 != node2) {
                if (size[node1] > size[node2]) {
                    int r = node1;
                    node1 = node2;
                    node2 = r;
                }
                parent.put(node1, node2);
                size[node2] += size[node1];
            }
            red[node1] |= red[node2];
            red[node2] |= red[node1];
            return 0;
        };

        return Arrays
                .stream(roads)
                .map(roadArray -> union.apply(roadArray))
                .reduce(0, Integer::sum);
    }

    static int minTimeReference2(int[][] roads, int[] machines) {
        int noOfNodes = roads.length + 1;
        boolean[] isMachine = new boolean[noOfNodes];
        Arrays.stream(machines).forEach(m -> isMachine[m] = true);

        //Adjacency List of roads
        List<int[]>[] adj = Stream.generate(ArrayList::new).limit(noOfNodes).toArray(List[]::new);

        for (int[] road : roads) {
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }

        boolean[] seen = new boolean[noOfNodes];
        final int[] total = new int[1];

        dfs = (city, time) -> {
            seen[city] = true;
            int maxTime = 0;
            int sumTime = 0;

            for (int[] neighbor : adj[city]) {
                if (seen[neighbor[0]]) continue;

                int neighborTime = dfs.applyAsInt(neighbor[0], neighbor[1]);

                sumTime += neighborTime;
                maxTime = Math.max(maxTime, neighborTime);
            }

            if (isMachine[city]) {
                total[0] += sumTime;
                return time;
            } else {
                total[0] += sumTime - maxTime;
                return Math.min(maxTime, time);
            }
        };

        dfs.applyAsInt(0, 0);
        return total[0];
    }
}


//https://programs.programmingoneonone.com/2021/03/hacekrrank-matrix-solution.html
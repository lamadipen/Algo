package hackerrank.interviewprepkit.trees;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BalancedForestSolutionTest {

    @Test
    public void balancedForestTest1() {
        String stringNodes = "1 2 2 1 1";
        String stringEdges = "1 2\n" +
                "1 3\n" +
                "3 5\n" +
                "1 4";

        List<Integer> listNodes = buildNodes(stringNodes);
        List<List<Integer>> listEdges = buildEdges(stringEdges);
        int result = BalancedForestSolution.balancedForest(listNodes, listEdges);
        Assert.assertEquals(2, result);
    }

    @Test
    public void balancedForestTest2() {
        String stringNodes = "1 3 5";
        String stringEdges = "1 3";

        List<Integer> listNodes = buildNodes(stringNodes);
        List<List<Integer>> listEdges = buildEdges(stringEdges);
        int result = BalancedForestSolution.balancedForest(listNodes, listEdges);
        Assert.assertEquals(-1, result);
    }

    private List<List<Integer>> buildEdges(String stringEdges) {
        List<String> listStringEdges = new ArrayList<>();
        new BufferedReader(
                new StringReader(stringEdges))
                .lines()
                .forEach((line) -> listStringEdges.add(line)
                );
        List<List<Integer>> listEdges = listStringEdges.stream()
                .map(line -> {
                    String[] e = line.replaceAll("\\s+$", "").split(" ");
                    List<Integer> resutl = Arrays.stream(e).map(Integer::parseInt).collect(toList());
                    return resutl;
                })
                .collect(toList());
        return listEdges;
    }

    private static List<Integer> buildNodes(String stringNodes) {
        return Stream.of(stringNodes.replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    }


    public static void main(String[] args) throws IOException {
        /*
        INPUT
2
5
1 2 2 1 1
1 2
1 3
3 5
1 4
3
1 3 5
1 3
1 2

OUTPUT
2
-1
        * */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, q).forEach(qItr -> {
            try {
                int inputSize = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> c = buildNodes(bufferedReader.readLine());

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, inputSize - 1).forEach(i -> {
                    try {
                        edges.add(
                                buildNodes(bufferedReader.readLine())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = BalancedForestSolution.balancedForest(c, edges);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
}
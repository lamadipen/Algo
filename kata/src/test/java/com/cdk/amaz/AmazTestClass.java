package com.cdk.amaz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AmazTestClass {
    @Test
    public void threeKeyWordSuggetionTest() {
        //List<String> mouse = threeKeyWordSuggetion(5, Arrays.asList(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}), "mouses");


        List<List<String>> mouses = threeKeyWordSuggetionRange(5, Arrays.asList(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}), "mouses");
        ;
        System.out.println("Result " + mouses);

    }

    private List<String> threeKeyWordSuggetion(int numberOfReview, List<String> repository, String customerQuery) {
        if(customerQuery == null || customerQuery.isEmpty()) return Collections.emptyList();
        if(numberOfReview == 0) return Collections.emptyList();

        if (customerQuery.length() >= 2) {
            List<String> collect = repository
                    .stream()
                    .filter(item -> item.contains(customerQuery))
                    .sorted()
                    .limit(3)
                    .collect(Collectors.toList());
            return collect;
        }
        return Collections.emptyList();
    }


    private List<List<String>> threeKeyWordSuggetionRange(int numberOfReview, List<String> repository, String customerQuery) {
        if(customerQuery == null || customerQuery.isEmpty()) return Collections.emptyList();
        if(numberOfReview == 0) return Collections.emptyList();
        StringBuilder sb = new StringBuilder(customerQuery);

        return IntStream.rangeClosed(2, customerQuery.length())
                .mapToObj(i -> sb.substring(0, i))
                .map(prefix ->
                        repository
                                .stream()
                                .filter(item -> item.startsWith(prefix))
                                .sorted()
                                .limit(3)
                                .collect(Collectors.toList())
                ).collect(Collectors.toList());
    }

    @Test
    public void minHoursTest(){
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(new Integer[]{0, 1, 1, 0, 1}));
        grid.add(Arrays.asList(new Integer[]{0, 1, 0, 1, 0}));
        grid.add(Arrays.asList(new Integer[]{0, 0, 0, 0, 1}));
        grid.add(Arrays.asList(new Integer[]{0, 1, 0, 0, 0}));
        minHours(4,5,grid);
    }

    private void minHours(int row, int column, List<List<Integer>> grid) {
        boolean [] visited = new boolean[100];
        int count = 0;
        for(int i = 0; i < grid.get(0).size()-1; i++) {
            if(!visited[i]) {
                System.out.println("Compnent: " );
                dfs(i,grid,visited);
                ++count;
            }
        }
        System.out.println("This is the count " + count);
    }

    public static void dfs(int i, List<List<Integer>> graph, boolean[] visited) {
        if(!visited[i]){
            visited[i] = true; // Mark node as "visited"
            System.out.print(i+1 + " ");

            for (int j = 0; j < graph.get(i).size()-1; j++) {
                if (graph.get(i).get(j)==1 && !visited[j]) {
                    dfs(j, graph, visited); // Visit node
                }
            }
        }
    }

}


///
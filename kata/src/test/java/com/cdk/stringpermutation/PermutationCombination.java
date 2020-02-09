package com.cdk.stringpermutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationCombination {

    @Test
    public void testCombination() {
        char[] array = new char[]{'A', 'B', 'C'};
        char[] buffer = new char[2];
        combination(array, 0, buffer, 0);
    }

    private void combination(char[] array, int pointer, char[] buffer, int bufferPointer) {
        if (bufferPointer == buffer.length) {
            printBuffer(buffer);
            return;
        }
        if (pointer == array.length) return;

        for (int i = pointer; i < array.length; i++) {
            buffer[bufferPointer] = array[i];
            combination(array, i + 1, buffer, bufferPointer + 1);
        }
    }


    private void printBuffer(char[] buffer) {
        Stream.of(buffer).forEach(System.out::println);
    }

    @Test
    public void testPermutation() {
        char[] array = new char[]{'A', 'B', 'C'};
        boolean[] visited = new boolean[array.length];
        char[] buffer = new char[2];

        permutation(array, 0, buffer, visited);
    }

    private void permutation(char[] array, int bufferPointer, char[] buffer, boolean[] visited) {
        if (buffer.length == bufferPointer) {
            printBuffer(buffer);
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                buffer[bufferPointer] = array[i];
                visited[i] = true;
                permutation(array, bufferPointer + 1, buffer, visited);
                visited[i] = false;
            }
        }
    }

    @Test
    public void solutionTest(){
        Solution solution = new Solution();
        solution.permute(new int[]{1, 2, 3});
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] buffer = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList();

        permutation(nums,buffer,0,visited,result);
        return result;
    }

    public void permutation(int[] a,
                            int[] buffer,
                            int bp,
                            boolean[] visited,
                            List<List<Integer>> result){
        if(buffer.length == bp){
            List<Integer> buffList = new ArrayList<>();
            for (int i : buffer) {
                buffList.add(i);
            }
            result.add(buffList);
        return;
        }
        for(int i = 0; i < a.length; i++){
            if(!visited[i]){
                buffer[bp] = a[i];
                visited[i] = true;
                permutation(a,buffer,bp+1,visited,result);
                visited[i] = false;
            }
        }
    }
}

package com.cdk.stringpermutation;

import org.junit.Test;

import java.util.stream.Stream;

//https://leetcode.com/problems/permutations-ii/
public class Permutation2 {
        @Test
        public void permutation2Test(){
            int[] array = {1,1,2};
            boolean[] visited = new boolean[array.length];
            int[] buffer = new int[array.length];
            int bufferPoint = 0;

            permuteUnique(array, buffer, bufferPoint, visited);
        }

    private void permuteUnique(int[] array, int[] buffer, int bufferPoint, boolean[] visited) {
        if (buffer.length == bufferPoint) {
            print(buffer);
        }
        for (int i = 0; i < array.length; i++) {
            if(!visited[i]){
                buffer[bufferPoint] = array[i];
                visited[i] = true;
                permuteUnique(array, buffer, bufferPoint+1, visited);
                visited[i] = false;
            }
        }
    }

    private void print(int[] buffer) {
        for (int value : buffer
        ) {
            System.out.print(value);
        }
        System.out.println("");
    }
}

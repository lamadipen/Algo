package com.cdk.arrayandstrings;

import org.junit.Test;

import java.util.HashMap;

public class FindTarget {
    @Test
    public void findTargetTest(){
        int[] array = {-1, 2, 3, -2, 4, 5, 7};
        findTarget(array, 2);
        int[] array1 = {2, -2, 4, 5, 7};
        findTarget(array1, 2);
    }

    private void findTarget(int[] array, int target) {
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            if (sum == target) {
                printResult(i);
            }
            if (sum == 0) {
                printResult(i);
            }
        }

    }

    private void printResult(int endIndex) {
        System.out.println("we got target from 0" + " to " +endIndex);
    }

    @Test
    public void findTargetPairTest(){
        int[] array = {6, 3, 5, 2, 1, 7};
        findPairTarget(array, 4);
    }

    private void findPairTarget(int[] array, int target) {
        HashMap<Integer, Integer> map= new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(array[i] > target) continue;
            map.put(target - array[i], i);
            if(map.containsKey(array[i])){
                System.out.println(map.get(array[i]) + ", " + i);
            }
        }

    }
}

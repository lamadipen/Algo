package com.dp.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        //int[] A = {4,2,3};
//        int k = 3;
//        int[] A = {3,-1,0,2};
        //int k = 1;
        int[] A = {2,-3,-1,5,-4};
        int k = 2;

        //largestSumAfterKNegations(A, k);
        largestSumAfterKNegationsLinear(A, k);
        largestSumAfterKNegationsAnotherway(A,k);
    }

    private static void largestSumAfterKNegations(int[] a, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int x: a){
            priorityQueue.add(x);
        }

        while (k-- > 0) {
            priorityQueue.add(-priorityQueue.poll());
        }

        int sum = 0;
        // Priority queue keep element in its natural order using comparator
        for (int element : priorityQueue){
            sum += element;
            System.out.println(element);
        }
        System.out.println("This lasgets sum ::  "+ sum);
    }

    public static void largestSumAfterKNegationsLinear(int[] A, int K) {
        while (K-- != 0) {
            Arrays.sort(A);
            A[0] *= -1;
        }

        int sum = IntStream.of(A).sum();
        System.out.println(sum);
    }

    public static void largestSumAfterKNegationsAnotherway(int[] A, int K) {
        if (A == null || A.length == 0) {
            return;
        }
        Arrays.sort(A);
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (K > 0 && A[i] < 0) {
                A[i] = -A[i];
                K--;
            }
            ans += A[i];
            min = Math.min(min, A[i]);
        }
        if (K == 0 || K % 2 == 0) {
            System.out.println(ans);
        } else {
            System.out.println(ans - min * 2);
        }
    }
}

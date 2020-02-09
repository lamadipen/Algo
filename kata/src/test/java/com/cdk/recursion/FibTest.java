package com.cdk.recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FibTest {

    @Test
    public void fibRecursionTest() {
        Assert.assertEquals(5, fibRecursion(5));
        Assert.assertEquals(8, fibRecursion(6));
        Assert.assertEquals(13, fibRecursion(7));
        //Take long time to return the result as alternative we use Memoization
//        Assert.assertEquals(13, fibRecursion(1000));
    }

    @Test
    public void fibRecursionMemoizationTest() {
        Assert.assertEquals(5, fibRecursionMemoization(5));
        Assert.assertEquals(8, fibRecursionMemoization(6));
        Assert.assertEquals(13, fibRecursionMemoization(7));
        Assert.assertEquals(13, fibRecursionMemoization(1000));
    }

    @Test
    public void fibIterativeTest() {
        Assert.assertEquals(5, fibIterative(5));
        Assert.assertEquals(8, fibIterative(6));
        Assert.assertEquals(13, fibIterative(7));
        Assert.assertEquals(1556111435, fibIterative(1000));
    }

    public int fibRecursion(int input) {
        if (input == 0) return 0;
        if (input == 1) return 1;

        return fibRecursion(input - 1) + fibRecursion(input - 2);
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int fibRecursionMemoization(int input) {
        if(cache.containsKey(input)) return cache.get(input);
        if (input == 0) return 0;
        if (input == 1) return 1;

        int result = fibRecursion(input - 1) + fibRecursion(input - 2);
        cache.put(input, result);
        return result;
    }

    public int fibIterative(int input) {
        int[] array = new int[input+1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2 ; i <=input; i++ ){
            array[i] = array[i-1] + array[i-2];
        }
        return array[input];
    }

}

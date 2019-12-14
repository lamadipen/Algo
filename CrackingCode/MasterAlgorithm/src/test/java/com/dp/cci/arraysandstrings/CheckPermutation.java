package com.dp.cci.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    /**
     * Given two string write a method to decide if one is a permutation of the other
     */
    @Test
    public void checkPermutationTest() {
        Assert.assertFalse(checkPermutation("ball", "ll"));
        Assert.assertTrue(checkPermutation("ball", "lalb"));
        Assert.assertFalse(checkPermutation("ball", "lalc"));
    }

    private boolean checkPermutation(String input1, String input2) {
        if (input1.length() != input2.length())
            return false;

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < input1.length(); i++) {
            char key = input1.charAt(i);
            if (charCount.containsKey(key)) {
                charCount.put(key, charCount.get(key) + 1);
            } else {
                charCount.put(key, 1);
            }
        }


        for (int i = 0; i < input2.length(); i++) {
            char key = input2.charAt(i);
            if (charCount.containsKey(key)) {
                charCount.put(key, charCount.get(key) - 1);
            }
        }
        int checker = 0;
        for (Map.Entry<Character,Integer> entry : charCount.entrySet()) {
            checker += entry.getValue();
        }

        return (checker == 0) ? true : false;
    }
}

package com.cdk.arrayandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationOfString {

    @Test
    public void permutationTest() {
        Assert.assertTrue(isPermutation("ball", "llab"));
        Assert.assertFalse(isPermutation("bal", "llab"));
        Assert.assertFalse(isPermutation("ball", "fjab"));
    }

    //run time O(nlogn)
    private boolean isPermutation(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }
        char[] input1Array = input1.toCharArray();
        char[] input2Array = input2.toCharArray();
        Arrays.sort(input1Array);
        Arrays.sort(input2Array);

        return Arrays.equals(input1Array, input2Array);
    }


    @Test
    public void permutationDataStructureTest(){
        Assert.assertFalse(permutationWithMap("ball", "hal"));
        Assert.assertTrue(permutationWithMap("ball", "ball"));
        Assert.assertTrue(permutationWithMap("god", "dog"));

    }

    private boolean permutationWithMap(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input1.length(); i++) {
            char key1 = input1.charAt(i);
            char key2 = input2.charAt(i);
            if(map.containsKey(key1)){
                map.put(key1, map.get(key1) + 1);
            }else{
                map.put(key1, 1);
            }
            if (map.containsKey(key2)) {
                map.put(key2, map.get(key2) - 1);
            }else{
                map.put(key2, -1);
            }
        }
        int checker = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            checker += entry.getValue();
        }

        return  checker == 0 ? true : false;
    }
}

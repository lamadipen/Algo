package com.dp.cci.arraysandstring;

import java.util.Arrays;

public class CheckPermutation {

    public static boolean isPermutationBySorting(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s2Array);

        String s1Sorted = Arrays.toString(s1Array);
        String s2Sorted = Arrays.toString(s2Array);

        return s1Sorted.equals(s2Sorted);
    }

    public static boolean isPermutationByArray(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] charArray = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i);
            charArray[index]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i);
            charArray[index]--;

            if(charArray[index] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //nlog(n) as most efficient sorting algo is nlog(n)
//        ;System.out.println(isPermutationBySorting("good", "dog"));

        //nlog(n) as most efficient sorting algo is nlog(n)
        System.out.println(isPermutationByArray("god", "dog"));
        System.out.println(isPermutationByArray("God", "dog"));
        System.out.println(isPermutationByArray("good", "dog"));




    }
}

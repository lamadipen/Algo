package com.dp.hrank.java;

import java.util.HashSet;
import java.util.Set;

/** Find the longest substirng for the string **/
public class LongestSubString {

    public static void main(String... args) {
        System.out.println(longetSubstring("abcabcbbccd")); //expected 3
        System.out.println(longetSubstring("abcabcdaee")); //expected 4
        System.out.println(longetSubstring("abcadee")); //expected 5
    }

    public static int longetSubstring(String s) {

        if (s  == null || s.length() < 1) {
            return 0;
        }

        Set<Character> mySet = new HashSet<>();
        int longest = 0;
        int start = 0;


        for (int i = start; i < s.length(); i++) {

            if (mySet.contains(s.charAt(i))) {

                if (longest < mySet.size()) {
                    longest = mySet.size();
                }
                mySet.clear();
                start++;
                i = start;
            }
            mySet.add(s.charAt(i));
           // System.out.println(s.charAt(i));
        }
        return longest;
    }


}

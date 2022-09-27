package com.leetcode.challanges.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimunWindowSubString {
    public static String minWindow(String input1, String target) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        for (Character letter : target.toCharArray()) {
            targetMap.put(letter, targetMap.getOrDefault(letter, 0) + 1);
        }
        int have = 0;
        int needed = target.length();
        int left = 0;
        int resultLength = input1.length() + 1;
        int[] result = new int[]{-1, -1};

        for (int right = 0; right < input1.length(); right++) {
            char currentChar = input1.charAt(right);

            window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);

            if (targetMap.containsKey(currentChar) && targetMap.get(currentChar) == window.get(currentChar)) {
                have++;
            }

            while (have == needed) {
                //update the result
                if (right - left + 1 < resultLength) {
                    resultLength = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }
                //delete from left of the window
                char leftCharacter = input1.charAt(left);
                window.put(leftCharacter, window.getOrDefault(left, 0) - 1);

                if (targetMap.containsKey(leftCharacter) && window.get(leftCharacter) < targetMap.get(leftCharacter)) {
                    have--;
                }
                left++;
            }
        }

        if (result[1] - result[0] < input1.length()) {
            return input1.substring(result[0], result[1] + 1);
        } else {
            return "";
        }
    }

    /***
     *  Runtime O()
     *  space complexity O(target)
     * */
    public static String minWindow2(String input1, String target) {
        if (target.isBlank()) return "";

        Map<Character, Integer> targetMap = new HashMap<>();

        for (Character letter : target.toCharArray()) {
            targetMap.put(letter, targetMap.getOrDefault(letter, 0) + 1);
        }
        int matched = 0;
        int subStr = 0;
        int left = 0;
        int resultLength = input1.length() + 1;

        for (int right = 0; right < input1.length(); right++) {
            char currentChar = input1.charAt(right);

            if (targetMap.containsKey(currentChar)) {
                targetMap.put(currentChar, targetMap.get(currentChar) - 1);
                if (targetMap.get(currentChar) == 0) {
                    matched++;
                }
            }

            while (matched == targetMap.size()) {
                //update the result
                if (right - left + 1 < resultLength) {
                    resultLength = right - left + 1;
                    subStr = left;
                }
                //delete from left of the window
                char leftCharacter = input1.charAt(left++);

                if (targetMap.containsKey(leftCharacter)) {
                    if(targetMap.get(leftCharacter) == 0) matched--;
                    targetMap.put(leftCharacter, targetMap.get(leftCharacter)+1);
                }
            }
        }
        return  resultLength  > input1.length() ? "": input1.substring(subStr,subStr+resultLength);
    }
}

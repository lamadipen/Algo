package com.leetcode.challanges.two_pointers;

/**
 * Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 *
 * https://www.youtube.com/watch?v=jJXJ16kPFWg
 *
 * */
public class ValidPalindromeSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(n)
     * */
    public static boolean isPalindrome(String s) {
        StringBuilder content = new StringBuilder();

        for (Character character : s.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                content.append(character);
            }
        }

        content = new StringBuilder(content.toString().toLowerCase().replace(" ", ""));

        return content.toString().equals(content.reverse().toString());
    }


    /**
     * Runtime O(n)
     * Space Complexity O(1)
     * */
    public static boolean isPalindromeOptimized(String s) {
        int left =0;
        int right = s.length() -1;

        while (left < right) {
            while (left < right & !isValidChar(s.charAt(left))){
                left++;
            }

            while (left < right & !isValidChar(s.charAt(right))){
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))  != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isValidChar(char character) {
        return  ('a' <= character && character <= 'z') ||
                ('A' <= character && character <= 'Z') ||
                ('0' <= character && character <= '9');

    }
}
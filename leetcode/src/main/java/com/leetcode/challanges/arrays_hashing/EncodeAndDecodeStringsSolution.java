package com.leetcode.challanges.arrays_hashing;

import java.util.ArrayList;
import java.util.List;
/**
 * Encode and Decode Strings
 * https://www.lintcode.com/problem/659/
 *
 * https://www.youtube.com/watch?v=B1k_sxOSgv8
 * */
public class EncodeAndDecodeStringsSolution {

    /**
     * Runtime O(n)
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String word : strs) {
            int length = word.length();
            encodedString.append(length+"#");
            encodedString.append(word);
        }
        return encodedString.toString();
    }

    /**
     * Runtime O(n)
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            String length ="";

            while (str.charAt(i) != '#') {
                length += str.charAt(i);
                i++;
            }
            int wordLength = Integer.parseInt(length);
            i++;

            String word = "";
            for (int j = i; j < wordLength + i; j++) {
                word += str.charAt(j);
            }
            decodedString.add(word);
            i = i + wordLength - 1;
        }
        // write your code here
        return decodedString;
    }

}

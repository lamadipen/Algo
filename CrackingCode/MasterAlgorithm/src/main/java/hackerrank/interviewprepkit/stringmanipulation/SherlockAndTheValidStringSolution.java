package hackerrank.interviewprepkit.stringmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Interview Preparation Kit | String Manipulation | Sherlock and the Valid String
 * Sherlock and the Valid String
 */
public class SherlockAndTheValidStringSolution {

    public String isValid(String s) {
        final String GOOD = "YES";
        final String BAD = "NO";

        if (s.isEmpty()) return BAD;
        if (s.length() <= 3) return GOOD;

        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        Arrays.sort(letters);
        int i = 0;

        while (letters[i] == 0) {
            i++;
        }

        System.out.println(Arrays.toString(letters));

        int min = letters[i];
        int max = letters[25];
        String ret = BAD;
        if (min == max) {
            ret = GOOD;
        } else {
            // remove one letter at higher frequency or the lower frequency
            if (((max - min == 1) && max > letters[24]) ||
                    (min == 1) && letters[i + 1] == max) {
                ret = GOOD;
            }
        }
        return ret;
    }

    public String isValidSolution(String s) {
        final String GOOD = "YES";
        final String BAD = "NO";

        if (s.isEmpty()) return BAD;
        if (s.length() <= 3) return GOOD;

        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        Arrays.sort(letters);
        int i = 0;

        while (letters[i] == 0) {
            i++;
        }

        System.out.println(Arrays.toString(letters));

        int min = letters[i];
        int max = letters[25];
        String ret = BAD;
        if (min == max) {
            ret = GOOD;
        } else {
            // remove one letter at higher frequency or the lower frequency
            if (((max - min == 1) && max > letters[24]) ||
                    (min == 1) && letters[i + 1] == max) {
                ret = GOOD;
            }
        }
        return ret;
    }


    public String isValidOwnSoluiton(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        int minimumCharOccurance = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (charCount.containsKey(key)) {
                charCount.put(key, charCount.get(key) + 1);
                if (charCount.get(key) < minimumCharOccurance) {
                    minimumCharOccurance = charCount.get(key);
                }
            } else {
                charCount.put(key, 1);
            }
        }

        int uniqueCharSize = charCount.size();

        if (s.length() % uniqueCharSize == 0) {
            return "YES";
        }

        int stringSizeAfterAdjustment = 0;
        for (Map.Entry<Character, Integer> entrySet : charCount.entrySet()) {
            if (charCount.get(entrySet.getKey()) > minimumCharOccurance) {
                charCount.put(entrySet.getKey(), charCount.get(entrySet.getKey()) - 1);
            }
            stringSizeAfterAdjustment += charCount.get(entrySet.getKey());
        }

        if (stringSizeAfterAdjustment % uniqueCharSize == 0 && stringSizeAfterAdjustment == s.length() - 1) {
            return "YES";
        }

        return "NO";
    }
}


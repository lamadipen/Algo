package kforce;

import java.util.HashMap;
import java.util.Map;

/**
 * Interview 2021 April 8
 */
public class InterviewSolution {

    int binaryPatternMatching(String pattern, String s) {

        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);
        vowels.put('y', 0);

        int patternLength = pattern.length();
        int matchCount = 0;
        for (int i = 0; i < s.length() - patternLength + 1; i++) {
            String substring = s.substring(i, i + patternLength);
            char[] chars = substring.toCharArray();
            String result = "";
            for (char c : chars) {
                result += vowels.getOrDefault(c, 1);
            }
            if (result.equals(pattern)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public void readCsvFile() {


    }


    String addKbeforeFs(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'f' || chars[i] == 'F') {
                sb.append('K');
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }


}


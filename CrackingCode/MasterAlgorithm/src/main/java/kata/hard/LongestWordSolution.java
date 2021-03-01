package kata.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Hard
 * LongestWord
 * CC: pg 188 Q: 17.15
 */
public class LongestWordSolution {

    String getLongestWord(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());

        for (String word : words) {
            map.put(word, true);
        }
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String left = word.substring(0, i);
                String right = word.substring(i);

                if (map.get(left) != null && map.get(right) != null && map.get(left) == true && map.get(right) == true) {
                    return word;
                }
            }
        }
        return "";
    }

    public String getLongestWordMoreWords(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());

        for (String word : words) {
            map.put(word, true);
        }
        for (String word : words) {
            if (canBuildWords(word, true, map)) {
                return word;
            }
        }
        return "";
    }

    private boolean canBuildWords(String word, boolean isRootWord, Map<String, Boolean> map) {
        if (map.containsKey(word) && !isRootWord) {
            return map.get(word);
        }
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (map.containsKey(left) && map.get(left) == true && canBuildWords(right, false, map)) {
                return true;
            }
        }
        map.put(word, false);
        return false;
    }
}

package kata.moderate;

import java.util.*;

/**
 * Moderate
 * T9
 * CC: pg 184 Q: 16.20
 */
public class T9Solution {

    char[][] t9Letters = {null,
            null,
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    /**
     * Runtime 4^n
     */
    public List<String> getValidT9Words(String number, Set<String> words) {
        List<String> results = new ArrayList();
        getValidT9Words(number, 0, "", words, results);
        return results;
    }

    private void getValidT9Words(String number, int index, String prefix, Set<String> words, List<String> results) {
        if (index == number.length() && words.contains(prefix)) {
            results.add(prefix);
            return;
        }
        if (index >= number.length()) {
            return;
        }
        char digit = number.charAt(index);
        char[] letters = getLetters(digit);

        if (letters != null) {
            for (char letter : letters) {
                getValidT9Words(number, index + 1, prefix + letter, words, results);
            }
        }
    }

    private char[] getLetters(char digit) {
        if (!Character.isDigit(digit)) {
            return null;
        }
        int index = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[index];
    }


    Map<String, List<String>> dictionary = new HashMap<>();


    /**
     * O(1) after the initilization
     * O(n) to initilize the dictonary
     **/
    public List<String> getValidT9WordsOptimized(String number) {
        return dictionary.get(number);
    }

    void initilizeDictionary(Set<String> words) {
        Map<Character, Character> letterToNumberMap = createLetterToNumberMap();
        for (String word : words) {
            String numbers = convertToT9(word, letterToNumberMap);
            if (dictionary.containsKey(numbers)) {
                List<String> strings = dictionary.get(numbers);
                strings.add(word);
                dictionary.put(numbers, strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(word);
                dictionary.put(numbers, strings);
            }
        }
    }

    private String convertToT9(String word, Map<Character, Character> letterToNumberMap) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (letterToNumberMap.containsKey(c)) {
                char digit = letterToNumberMap.get(c);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    private Map<Character, Character> createLetterToNumberMap() {
        Map<Character, Character> letterToNumberMap = new HashMap<>();
        for (int i = 0; i < t9Letters.length; i++) {
            char[] letters = t9Letters[i];
            if (letters != null) {
                for (char letter : letters) {
                    char c = Character.forDigit(i, 10);
                    letterToNumberMap.put(letter, c);
                }
            }
        }
        return letterToNumberMap;
    }
}

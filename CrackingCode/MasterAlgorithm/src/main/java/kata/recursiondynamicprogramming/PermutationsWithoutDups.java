package kata.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {

    public List<String> finaAllPermutaion(String input) {
        if (input == null) {
            return null;
        }
        List<String> permutations = new ArrayList<>();

        if (input.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = input.charAt(0);
        String remainder = input.substring(1);

        List<String> words = finaAllPermutaion(remainder);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String result = insertCharAt(word, first, i);
                permutations.add(result);
            }
        }

        return permutations;
    }

    private String insertCharAt(String word, char first, int index) {
        String start = word.substring(0, index);
        String end = word.substring(index);
        return start + first + end;
    }


    public List<String> finaAllPermutaionIterative(String input) {
        int inputLength = input.length();
        List<String> permutations = new ArrayList<>();

        if (inputLength == 0) {
            permutations.add("");
            return permutations;
        }

        for (int i = 0; i < inputLength; i++) {
            String start = input.substring(0, i);
            String end = input.substring(i + 1, inputLength);
            List<String> temp = finaAllPermutaionIterative(start + end);

            for (String word : temp) {
                permutations.add(input.charAt(i) + word);
            }
        }
        return permutations;
    }
}

package homedepot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeDepotInterviewSolution {
    /**
     * This is a test string and this test is to display the words in descending order of their occurrence
     */
    public static Map<String, Integer> higestOrder(String input) {
        if (input == null) {
            return null;
        }
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = input.split(" ");

        for (String word : words) {
            String key = word.toLowerCase();
            if (wordCount.containsKey(key)) {
                wordCount.put(key, wordCount.get(key) + 1);
            } else {
                wordCount.put(key, 1);
            }
        }

        LinkedHashMap<String, Integer> result = wordCount
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));

        return result;
    }


}

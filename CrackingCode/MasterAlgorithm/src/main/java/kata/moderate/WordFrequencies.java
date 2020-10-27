package kata.moderate;

import java.util.HashMap;
import java.util.Map;

/**
 * Moderate
 * WordFrequencies
 * CC: pg 181 Q: 16.2
 */
public class WordFrequencies {
    Map<String, Integer> wordCountMap = new HashMap<>();

    /**
     * Runtime is O(n) as we have to navigate to each line in book
     */
    public int getCount(String[] books, String target) {
        int count = 0;
        String sanitizedTarget = target.trim().toLowerCase();
        for (String word : books) {
            if (word.trim().toLowerCase().equals(sanitizedTarget)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Runtime is O(1) if we run the setUpDictionary method before the call
     * as it will do all the heavy lifting
     */
    public int getCountRepetitiveCall(String target) {
        String sanitizedTarget = target.trim().toLowerCase();
        if (wordCountMap.containsKey(sanitizedTarget)) {
            return wordCountMap.get(sanitizedTarget);
        }
        return 0;
    }

    /**
     * Runtime is O(n) and space complexity is O(n) where n is number of words
     * This method will do initial setup so that repetitive call will run on O(1)
     * constant time.
     */
    public void setUpDictionary(String[] books) {
        for (String word : books) {
            String sanitizedWord = word.trim().toLowerCase();
            if (!sanitizedWord.equals("")) {
                if (wordCountMap.containsKey(sanitizedWord)) {
                    wordCountMap.put(sanitizedWord, wordCountMap.get(sanitizedWord) + 1);
                } else {
                    wordCountMap.put(sanitizedWord, 1);
                }
            }
        }
    }
}

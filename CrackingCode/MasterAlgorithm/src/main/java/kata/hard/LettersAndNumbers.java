package kata.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Hard
 * Letters And Numbers
 * CC: pg 186 Q: 17.5
 */
public class LettersAndNumbers {

    /**
     * Runtime O(n^3)
     *
     * @param arr
     * @return
     */
    public char[] findLongestSubArray(char[] arr) {
        for (int len = arr.length; len > 1; len--) {
            for (int i = 0; i <= arr.length; i++) {
                if (hasEqualNumberLetter(arr, i, i + len - 1)) {
                    return extractSubArray(arr, i, i + len - 1);
                }
            }
        }
        return null;
    }

    private boolean hasEqualNumberLetter(char[] arr, int start, int end) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                count++;
            } else if (Character.isDigit(arr[i])) {
                count--;
            }
        }
        return 0 == count;
    }

    private char[] extractSubArray(char[] arr, int start, int end) {
        char[] result = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = arr[i];
        }
        return result;
    }


    /**
     * Runtime O(n)
     *
     * @param arr
     * @return
     */
    public char[] findLongestSubArrayOptimized(char[] arr) {

        //get difference of letters and numbers in each index
        int[] deltas = calculateDeltas(arr);

        //get longest matching sequence using deltas
        int[] longestMatch = findLongestMatch(deltas);

        return extractSubArray(arr, longestMatch[0] + 1, longestMatch[1]);
    }

    private int[] calculateDeltas(char[] arr) {
        int[] deltas = new int[arr.length];
        int delta = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                delta++;
            } else if (Character.isDigit(arr[i])) {
                delta--;
            }
            deltas[i] = delta;
        }
        return deltas;
    }

    private int[] findLongestMatch(int[] deltas) {
        //delta value and current delta index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[] matches = new int[2];

        for (int index = 0; index < deltas.length; index++) {
            if (!map.containsKey(deltas[index])) {
                map.put(deltas[index], index);
            } else {
                Integer matchIndex = map.get(deltas[index]);
                int distance = index - matchIndex;
                int maxDistance = matches[1] - matches[0];

                if (distance > maxDistance) {
                    matches[1] = index;
                    matches[0] = matchIndex;
                }
            }
        }
        return matches;
    }
}

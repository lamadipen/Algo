package kata.moderate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Moderate
 * Pairs With Sum
 * CC: pg 185 Q: 16.24
 */
public class PairsWithSum {

    /**
     * Optimized Solution
     * O(n) runtime and space
     */
    public List<Pair> getPairWithSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Pair> result = new ArrayList<>();

        for (int value : array) {
            int delta = target - value;
            if (map.getOrDefault(delta, 0) > 0) {
                result.add(new Pair(value, delta));
                updateMapBy(map, delta, -1);
            } else {
                updateMapBy(map, value, 1);
            }
        }
        return result;
    }

    private void updateMapBy(Map<Integer, Integer> map, int key, int delta) {
        map.put(key, map.getOrDefault(key, 0) + delta);
    }

    /**
     * Alternate Solution
     * O(nlogn) for sorting + O(n) traversal => actual runtime  O(nlogn)
     */
    public List<Pair> getPairWithSumAlternate(int[] array, int target) {
        List<Pair> result = new ArrayList<>();

        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            int sum = array[first] + array[last];

            if (sum == target) {
                result.add(new Pair(array[first], array[last]));
                first++;
                last--;
            } else {
                if (sum < target) {
                    first++;
                } else {
                    last--;
                }
            }
        }
        return result;
    }
}

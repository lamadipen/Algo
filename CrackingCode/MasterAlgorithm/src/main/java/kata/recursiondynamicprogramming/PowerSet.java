package kata.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Recursion and dynamic programming
 * Power Set
 * CC: pg 135 Q: 8.4
 */
public class PowerSet {

    public List<List<Integer>> getAllSubSetsRecursive(List<Integer> set, int index) {
        List<List<Integer>> allSubSets;

        if (set.size() == index) {
            allSubSets = new ArrayList<>();
            allSubSets.add(Collections.emptyList());
        } else {
            allSubSets = getAllSubSetsRecursive(set, index + 1);
            int item = set.get(index);

            List<List<Integer>> moreSubSets = new ArrayList<>();

            for (List<Integer> subSet : allSubSets) {
                List<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subSet);
                newSubSet.add(item);
                moreSubSets.add(newSubSet);
            }
            allSubSets.addAll(moreSubSets);
        }
        return allSubSets;
    }
}

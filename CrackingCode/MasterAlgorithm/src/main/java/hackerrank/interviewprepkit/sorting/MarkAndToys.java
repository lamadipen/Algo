package hackerrank.interviewprepkit.sorting;

import java.util.Collections;
import java.util.List;

/**
 * Interview Preparation Kit | Sorting |Mark and Toys
 * Mark and Toys
 */
public class MarkAndToys {

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        int maxPurchase = 0;
        int currentTotal = 0;
        Collections.sort(prices);
        for (int i = 0; i < prices.size(); i++) {
            currentTotal += prices.get(i);
            if (currentTotal <= k) {
                maxPurchase++;
            } else {
                currentTotal -= prices.get(i);
            }
        }
        return maxPurchase;
    }
}

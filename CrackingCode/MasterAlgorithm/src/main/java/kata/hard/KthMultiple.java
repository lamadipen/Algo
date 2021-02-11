package kata.hard;

import java.util.*;

/**
 * Hard
 * Kth Multiple
 * CC: pg 187 Q: 17.9
 */
public class KthMultiple {

    /**
     * Runtime is O(n^3logn)
     * Unable to run due to memory constraints
     *
     * @param n
     * @return
     */
    public int getKthMagicNumber(int n) {
        List<Integer> possibilities = getPossibleKthFactors(n);
        Collections.sort(possibilities);
        return possibilities.get(n);
    }

    private List<Integer> getPossibleKthFactors(int n) {
        List<Integer> possibilities = new ArrayList<>();
        for (int a = 0; a <= n; a++) {
            int powA = (int) Math.pow(3, a);
            for (int b = 0; n <= n; b++) {
                int powB = (int) Math.pow(5, b);
                for (int c = 0; c < n; c++) {
                    int powC = (int) Math.pow(7, c);

                    int value = powA * powB * powC;

                    if (value < 0
                            || powA == Integer.MAX_VALUE
                            || powB == Integer.MAX_VALUE
                            || powC == Integer.MAX_VALUE
                    ) {
                        value = Integer.MAX_VALUE;
                    }
                    possibilities.add(value);
                }
            }
        }
        return possibilities;
    }

    /**
     * Runtime is O(n^2)
     *
     * @param n
     * @return
     */
    public int getKthMagicNumberOptimized1(int n) {
        if (n < 0) {
            return 0;
        }
        int value = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        addProducts(value, q);
        for (int i = 0; i <= n; i++) {
            value = removeMin(q);
            addProducts(value, q);
        }
        return value;
    }

    private int removeMin(Queue<Integer> q) {
        Integer min = q.peek();
        for (Integer value : q) {
            if (min > value) {
                min = value;
            }
        }
        while (q.contains(min)) {
            q.remove(min);
        }
        return min;
    }

    private void addProducts(int value, Queue<Integer> q) {
        q.add(value * 3);
        q.add(value * 5);
        q.add(value * 7);
    }

    public int getKthMagicNumberOptimized2(int n) {
        if (n < 0) {
            return 0;
        }
        int value = 0;
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        Queue<Integer> q7 = new LinkedList<>();
        q3.add(1);

        for (int i = 0; i <= n; i++) {
            Integer v3 = q3.size() > 0 ? q3.peek() : Integer.MAX_VALUE;
            Integer v5 = q5.size() > 0 ? q5.peek() : Integer.MAX_VALUE;
            Integer v7 = q7.size() > 0 ? q7.peek() : Integer.MAX_VALUE;

            value = Math.min(v3, Math.min(v5, v7));

            if (value == v3) {
                q3.remove();
                q3.add(value * 3);
                q3.add(value * 5);
            } else if (value == v5) {
                q5.remove();
                q5.add(value * 5);
            } else if (value == v7) {
                q7.remove();
            }
            q7.add(value * 7);
        }
        return value;
    }
}

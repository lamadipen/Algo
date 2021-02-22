package kata.hard;

/**
 * Hard
 * Majority Element
 * CC: pg 187 Q: 17.10
 */
public class MajorityElement {

    /**
     * O(n^2)
     * Doesn't work if there scattered element e.g. {1, 2, 5, 9, 1} => 1 should be returned but it doesn't
     *
     * @param array
     * @return
     */
    public int findMajorityElement(int[] array) {
        for (int n : array) {
            if (validate(array, n)) {
                return n;
            }
        }
        return -1;
    }

    private boolean validate(int[] array, int majority) {
        int count = 0;
        for (int n : array) {
            if (n == majority) {
                count++;
            }
        }
        return count > array.length / 2;
    }

    public int findMajorityElementOptimized(int[] array) {
        int candidate = getCandidate(array);
        return validate(array, candidate) ? candidate : -1;
    }

    /**
     * O(n)
     * Doesn't work if there scattered element e.g. {1, 2, 5, 9, 1} => 1 should be returned but it doesn't
     *
     * @param array
     * @return
     */
    private int getCandidate(int[] array) {
        int majority = 0;
        int count = 0;
        for (int n : array) {
            if (count == 0) {
                majority = n;
            }
            if (n == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}

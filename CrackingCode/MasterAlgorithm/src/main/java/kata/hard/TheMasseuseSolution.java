package kata.hard;

/**
 * Hard
 * The Masseuse
 * CC: pg 188 Q: 17.16
 */
public class TheMasseuseSolution {


    /**
     * Runtime O(2^n)
     *
     * @param times
     * @return
     */
    public int maxBookedMinutes(int[] times) {
        return maxBookedMinutes(times, 0);
    }

    private int maxBookedMinutes(int[] times, int index) {
        if (index >= times.length) {
            return 0;
        }
        int maxWith = times[index] + maxBookedMinutes(times, index + 2);
        int maxWithout = maxBookedMinutes(times, index + 1);

        return Math.max(maxWith, maxWithout);
    }

    /**
     * Runtime O(n) since we don't have to calculated 2nd path
     *
     * @param times
     * @return
     */
    public int maxBookedMinutesMemo(int[] times) {
        int[] memo = new int[times.length];
        return maxBookedMinutesMemo(times, 0, memo);
    }

    private int maxBookedMinutesMemo(int[] times, int index, int[] memo) {
        if (index >= times.length) {
            return 0;
        }

        if (memo[index] == 0) {
            int maxWith = times[index] + maxBookedMinutesMemo(times, index + 2, memo);
            int maxWithout = maxBookedMinutesMemo(times, index + 1, memo);

            memo[index] = Math.max(maxWith, maxWithout);
        }
        return memo[index];
    }


}

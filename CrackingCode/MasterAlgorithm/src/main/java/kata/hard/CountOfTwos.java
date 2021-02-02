package kata.hard;

/**
 * Hard
 * Count of 2s
 * CC: pg 186 Q: 17.6
 */
public class CountOfTwos {

    /**
     * Runtime O(nlogn)
     *
     * @param n
     * @return
     */
    public int countNumbersOfTwosTill(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count += countTwos(i);
        }
        return count;
    }

    private int countTwos(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 2) {
                count++;
            }
            n = n / 10;
        }
        return count;
    }


    public int countNumbersOfTwosTillOptimized(int n) {
        int count = 0;
        int digitLength = String.valueOf(n).length();
        for (int digit = 0; digit < digitLength; digit++) {
            count += count2sInRangeAtDigit(n, digit);
        }
        return count;
    }

    private int count2sInRangeAtDigit(int number, int digit) {
        int powerOf10 = (int) Math.pow(10, digit);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int runDown = number - number % nextPowerOf10;
        int runUp = runDown + nextPowerOf10;

        int result = (number / powerOf10) % 10;

        if (result < 2) {
            return runDown / 10;
        } else if (result == 2) {
            return runDown / 10 + right + 1;
        } else {
            return runUp / 10;
        }
    }

}

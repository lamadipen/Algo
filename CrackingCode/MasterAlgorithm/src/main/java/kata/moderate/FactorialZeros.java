package kata.moderate;

/**
 * Moderate
 * Factorial Zeros
 * CC: pg 181 Q: 16.5
 * Need to understand the question
 * 5! = 5*4*3*2*1 = 120 => trailing zero is 1.
 * <p>
 * 20! = 20*19*...*1 = 2432902008176640000 => trailing zero is 4.
 * <p>
 * Good Explanation
 * https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
 */
public class FactorialZeros {

    public int countFactZero(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += factorOf5Cont(i);
        }
        return count;
    }

    private int factorOf5Cont(int num) {
        int count = 0;

        while (num % 5 == 0) {
            count++;
            num = num / 5;
        }
        return count;
    }

    public int factorOf5ContOptimized(int num) {
        int count = 0;
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }
}
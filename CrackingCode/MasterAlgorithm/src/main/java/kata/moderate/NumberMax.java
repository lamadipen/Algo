package kata.moderate;

/**
 * Moderate
 * NumberMax
 * CC: pg 181 Q: 16.7
 */
public class NumberMax {

    public int maxBetween(int input1, int input2) {
        int k = sign(input1 - input2);
        int q = flip(k);
        return input1 * k + input2 * q;
    }

    private int sign(int input) {
        return flip((input >> 31) & 1);
    }

    private int flip(int input) {
        return 1 ^ input;
    }

    /**
     * This solution is for overflow condition
     */
    public int maxBetweenOverflowCondition(int input1, int input2) {
        int diff = input1 - input2;

        int sInput1 = sign(input1); //if input1 >= 0, then 1 else 0
        int sInput2 = sign(input2); //if input2 >= 0, then 1 else 0
        int sDiff = sign(diff); //depends on whether or not input1 - input2 overflows

        int useSignInput = sInput1 ^ sInput2;
        int useSignDiff = flip(sInput1 ^ sInput2);

        int k = useSignInput * sInput1 + useSignDiff * sDiff;
        int q = flip(k);
        return input1 * k + input2 * q;
    }
}

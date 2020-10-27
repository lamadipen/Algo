package kata.moderate;

/**
 * NumberSwapper
 * CC: pg 181 Q: 16.1
 */
public class NumberSwapper {

    public Result swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new Result(a, b);
    }

    /**
     * Used  bitwise XOR (XOR can be used to swap values in place)
     * try the example below to understand how swap will happen using XOR
     * 101 ^ 011 = 110
     * 110 ^ 101 = 011
     * 110 ^ 011 = 101
     */
    public Result swapBitManipulation(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new Result(a, b);
    }

    class Result {
        int a;
        int b;

        public Result(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

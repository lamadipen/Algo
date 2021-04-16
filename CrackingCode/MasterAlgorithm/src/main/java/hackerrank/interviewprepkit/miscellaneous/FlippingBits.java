package hackerrank.interviewprepkit.miscellaneous;

public class FlippingBits {

    static long flippingBits(long n) {
        long maxInt = (long) (Math.pow(2, 32) - 1);
        return maxInt - n;
    }
}

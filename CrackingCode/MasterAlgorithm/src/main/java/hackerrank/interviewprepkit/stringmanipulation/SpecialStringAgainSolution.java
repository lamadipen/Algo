package hackerrank.interviewprepkit.stringmanipulation;

/**
 * Interview Preparation Kit | String Manipulation | Special String Again
 * Special String Again
 */
public class SpecialStringAgainSolution {

    static long substrCount(int n, String s) {
        long counter = n;
        int consecutiveCharCount = 1;
        int midIndex = -1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                counter += consecutiveCharCount;
                consecutiveCharCount++;

                if (midIndex > 0) {
                    if ((midIndex - consecutiveCharCount) >= 0 && s.charAt(midIndex - consecutiveCharCount) == s.charAt(i))
                        counter++;
                    else midIndex = -1;
                }
            } else {
                consecutiveCharCount = 1;
                if ((i - 2) >= 0 && s.charAt(i - 2) == s.charAt(i)) {
                    counter++;
                    midIndex = i - 1;
                } else midIndex = -1;
            }
        }
        return counter;
    }
}

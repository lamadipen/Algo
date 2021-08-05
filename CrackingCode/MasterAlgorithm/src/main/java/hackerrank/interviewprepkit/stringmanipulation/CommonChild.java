package hackerrank.interviewprepkit.stringmanipulation;

/**
 * Interview Preparation Kit | String Manipulation | Common Child
 * Common Child
 */
public class CommonChild {

    /**
     * This is recursive solution from the back of the array
     * runtime O(2^(m+n))
     * space complexity O(m+n)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int longestCommonChild(String s1, String s2) {
        // Write your code here
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        return longestCommonChild(chars1, chars2, s1.length() - 1, s2.length() - 1);
    }

    private static int longestCommonChild(char[] chars1, char[] chars2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (chars1[i] == chars2[j]) {
            return 1 + longestCommonChild(chars1, chars2, i - 1, j - 1);
        } else { //if (chars1[i] != chars2[j])
            int firstLeg = longestCommonChild(chars1, chars2, i, j - 1);
            int secondLeg = longestCommonChild(chars1, chars2, i - 1, j);
            return Math.max(firstLeg, secondLeg);
        }
    }

    /**
     * This is recursive solution from the back of the array with Top down approach memoization (cache)
     * reduces the unnecessary calculation and steps in recursion
     * <p>
     * Runtime O(m*n)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int longestCommonChildWithCache(String s1, String s2) {
        // Write your code here
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Integer[][] cache = new Integer[s1.length()][s2.length()];
        return longestCommonChildWithCache(chars1, chars2, s1.length() - 1, s2.length() - 1, cache);
    }

    private static int longestCommonChildWithCache(char[] chars1, char[] chars2, int i, int j, Integer[][] cache) {
        if (i < 0 || j < 0) {
            return 0;
        } else if (cache[i][j] != null) {
            return cache[i][j];
        } else if (chars1[i] == chars2[j]) {
            return 1 + longestCommonChildWithCache(chars1, chars2, i - 1, j - 1, cache);
        } else {
            int firstLeg = longestCommonChildWithCache(chars1, chars2, i, j - 1, cache);
            int secondLeg = longestCommonChildWithCache(chars1, chars2, i - 1, j, cache);
            int maxLeg = Math.max(firstLeg, secondLeg);
            cache[i][j] = maxLeg;
            return maxLeg;
        }
    }

    /**
     * bottom up memoization
     * Runtime O(m*n) and space complexity O(m*n)
     * Now we can only optimize the space complexity
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int commonChildBottomUpApproach(String s1, String s2) {
        // Write your code here
        int s1Length = s1.length();
        int s2length = s2.length();
        int matrix[][] = new int[s1Length + 1][s2length + 1];
        for (int row = 1; row <= s1Length; row++) {
            for (int col = 1; col <= s2length; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    matrix[row][col] = matrix[row - 1][col - 1] + 1;
                } else {
                    matrix[row][col] = Math.max(matrix[row][col - 1], matrix[row - 1][col]);
                }
            }
        }
        return matrix[s1Length][s2length];
    }


    /**
     * bottom up memoization
     * Runtime O(m*n) and space complexity O(n)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int commonChildBottomUpApproachImprovedSpace(String s1, String s2) {
        // Write your code here
        int s1Length = s1.length();
        int s2length = s2.length();

        int[] memo = new int[s2length + 1];
        for (int row = 1; row <= s1Length; row++) {
            int previous = 0;
            for (int col = 1; col <= s2length; col++) {
                int temp = memo[col];
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    memo[col] = 1 + previous;
                } else {
                    memo[col] = Math.max(memo[col], memo[col - 1]);
                }
                previous = temp;
            }
        }
        return memo[s2length];
    }
}

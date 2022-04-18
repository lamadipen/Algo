package hackerrank.interviewprepkit.dynamicprogramming;


/**
 * Interview Preparation Kit | Dynamic Programming | Abbreviation
 * <p>
 * https://www.hackerrank.com/challenges/abbr/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 */
public class AbbreviationSolution {
    static String abbreviationSimpleSolution(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int[][] lengthMemo = new int[bLength + 1][aLength + 1];
        for (int i = 1; i <= bLength; i++) {
            for (int j = 1; j <= aLength; j++) {
                if (Character.isUpperCase(a.charAt(j - 1))) {
                    lengthMemo[i][j] = lengthMemo[i][j - 1] - 1;
                } else {
                    lengthMemo[i][j] = Math.max(lengthMemo[i][j - 1], lengthMemo[i - 1][j]);
                }
                if (Character.toLowerCase(a.charAt(j - 1)) == Character.toLowerCase(b.charAt(i - 1))) {
                    lengthMemo[i][j] = Math.max(lengthMemo[i - 1][j - 1] + 1, lengthMemo[i][j]);
                }
            }
        }
        return lengthMemo[bLength][aLength] == bLength ? "YES" : "NO";
    }
}

package hackerrank.interviewprepkit.recursionandbacktracking;

/**
 * Interview Preparation Kit | Recursion And Backtracking | Recursive Digit Sum
 */
public class RecursiveDigitSum {

    public static int superDigitSelfSolution1(String n, int k) {
        // Write your code here
        String input = "";
        while (k > 0) {
            input = input.concat(n);
            k--;
        }

        Integer result = Integer.valueOf(superDigit(input));
        System.out.println(result);
        return result;
    }

    public static int superDigitSelfSolution2(String n, int k) {
        // Write your code here
        Integer input = Integer.valueOf(n) * k;

        Integer result = Integer.valueOf(superDigit(input.toString()));
        System.out.println(result);
        return result;
    }

    public static String superDigit(String input) {
        if (input.length() == 1) {
            return input;
        }
        char[] chars = input.toCharArray();
        int sum = 0;
        for (char letter : chars) {
            sum += Character.getNumericValue(letter);
        }
        input = String.valueOf(sum);
        return superDigit(input);
    }

    static int superDigitSolution1(String number, int k) {
        if (number.length() > 1) {
            long sum = 0;
            for (int i = 0; i < number.length(); i++) {
                sum += Character.getNumericValue(number.charAt(i));
            }
            return superDigitSolution1(Long.toString(sum * k), 1);
        } else
            return Character.getNumericValue(number.charAt(0));
    }


}

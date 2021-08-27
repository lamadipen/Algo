package hackerrank.interviewprepkit.recursionandbacktracking;

import org.junit.Test;

public class RecursiveDigitSumTest {

    @Test
    public void superDigit1() {
        int result = RecursiveDigitSum.superDigitSolution1("148", 3);
        System.out.println(result);
    }

    @Test
    public void superDigit2() {
        int result = RecursiveDigitSum.superDigitSelfSolution2("9875", 4);
        System.out.println(result);
    }
}
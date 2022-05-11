package com.leetcode.challanges.stack;

import com.leetcode.challanges.two_pointers.ValidPalindromeSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesSolutionTest {

    @Test
    void isValidTest1() {
        boolean actual = ValidParenthesesSolution.isValid("()");
        Assertions.assertEquals(true, actual);
    }

    @Test
    void isValidTest2() {
        boolean actual = ValidParenthesesSolution.isValid("()[]{}");
        Assertions.assertEquals(true, actual);
    }

    @Test
    void isValidTest3() {
        boolean actual = ValidParenthesesSolution.isValid("(]");
        Assertions.assertEquals(false, actual);
    }

    @Test
    void isValidTest4() {
        boolean actual = ValidParenthesesSolution.isValid(")(");
        Assertions.assertEquals(false, actual);
    }

    @Test
    void isValidTest5() {
        boolean actual = ValidParenthesesSolution.isValid("(())");
        Assertions.assertEquals(true, actual);
    }
}
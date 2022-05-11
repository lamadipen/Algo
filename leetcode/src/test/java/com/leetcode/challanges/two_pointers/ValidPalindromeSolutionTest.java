package com.leetcode.challanges.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeSolutionTest {

    @Test
    void isPalindromeTest1() {
        boolean actual = ValidPalindromeSolution.isPalindrome("A man, a plan, a canal: Panama");
        Assertions.assertEquals(true, actual);
    }

    @Test
    void isPalindromeTest2() {
        boolean actual = ValidPalindromeSolution.isPalindrome("race a car");
        Assertions.assertEquals(false, actual);
    }

    @Test
    void isPalindromeTest3() {
        boolean actual = ValidPalindromeSolution.isPalindrome(" ");
        Assertions.assertEquals(true, actual);
    }


    @Test
    void isPalindromeTest4() {
        boolean actual = ValidPalindromeSolution.isPalindromeOptimized("A man, a plan, a canal: Panama");
        Assertions.assertEquals(true, actual);
    }

    @Test
    void isPalindromeTest5() {
        boolean actual = ValidPalindromeSolution.isPalindromeOptimized("race a car");
        Assertions.assertEquals(false, actual);
    }

    @Test
    void isPalindromeTest6() {
        boolean actual = ValidPalindromeSolution.isPalindromeOptimized(" ");
        Assertions.assertEquals(true, actual);
    }
}
package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainsDuplicateSolutionTest {

    @Test
    void containsDuplicateBruteForceTest1() {
        boolean actual = ContainsDuplicateSolution.containsDuplicateBruteForce(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(true,actual);
    }

    @Test
    void containsDuplicateBruteForceTest2() {
        boolean actual = ContainsDuplicateSolution.containsDuplicateBruteForce(new int[]{1, 2, 3, 4});
        Assertions.assertEquals(false,actual);
    }

    @Test
    void containsDuplicateBruteForceTest3() {
        boolean actual = ContainsDuplicateSolution.containsDuplicateBruteForce(new int[]{1,1,1,3,3,4,3,2,4,2});
        Assertions.assertEquals(true,actual);
    }

    @Test
    void containsDuplicateTest1() {
        boolean actual = ContainsDuplicateSolution.containsDuplicate(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(true,actual);
    }

    @Test
    void containsDuplicateTest2() {
        boolean actual = ContainsDuplicateSolution.containsDuplicate(new int[]{1, 2, 3, 4});
        Assertions.assertEquals(false,actual);
    }

    @Test
    void containsDuplicateTest3() {
        boolean actual = ContainsDuplicateSolution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
        Assertions.assertEquals(true,actual);
    }
}
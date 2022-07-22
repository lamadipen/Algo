package com.leetcode.challanges.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameSolutionTest {

    @Test
    void canJumpTest1() {
        boolean actual = JumpGameSolution.canJump(new int[]{2, 3, 1, 1, 4});
        Assertions.assertTrue(actual);
    }

    @Test
    void canJumpTest2() {
        boolean actual = JumpGameSolution.canJump(new int[]{3,2,1,0,4});
        Assertions.assertFalse(actual);
    }
}
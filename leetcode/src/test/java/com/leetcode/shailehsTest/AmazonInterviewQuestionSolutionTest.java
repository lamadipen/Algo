package com.leetcode.shailehsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import realcodetest.amazon.shailesh.AmazonInterviewQuestionSolution;

import java.util.Arrays;
import java.util.List;

class AmazonInterviewQuestionSolutionTest {

    @Test
    public void test1() {

        List<String> input = Arrays.asList(new String[]{"bag", "sfe", "cbh", "cbh", "red"});
        int actual = AmazonInterviewQuestionSolution.test1(input);
        Assertions.assertEquals(3,actual);
    }


    @Test
    public void test2() {
        char test = 'a';
        char test2 = (char) (test >>1);
        System.out.println(test2);

    }
}
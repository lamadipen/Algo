package com.shailesh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AmazonInterviewQuestionSolutionTest {

    @Test
    public void test1() {

        List<String> input = Arrays.asList(new String[]{"bag", "sfe", "cbh", "cbh", "red"});
        int actual = AmazonInterviewQuestionSolution.test1(input);
        Assertions.assertEquals(3,actual);
    }
}
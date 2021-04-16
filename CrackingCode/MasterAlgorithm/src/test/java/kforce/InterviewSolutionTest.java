package kforce;

import org.junit.Assert;
import org.junit.Test;

public class InterviewSolutionTest {

    @Test
    public void binaryPatternMatchingTest1() {
        InterviewSolution interviewSolution = new InterviewSolution();
        int amazing = interviewSolution.binaryPatternMatching("010", "amazing");
        Assert.assertEquals(2, amazing);
    }

    @Test
    public void binaryPatternMatchingTest2() {
        InterviewSolution interviewSolution = new InterviewSolution();
        int amazing = interviewSolution.binaryPatternMatching("00", "aaaaaaaaaa");
        Assert.assertEquals(9, amazing);
    }

    @Test
    public void addKbeforeFs() {
        InterviewSolution interviewSolution = new InterviewSolution();
        String force = interviewSolution.addKbeforeFs("force");
        Assert.assertEquals("Kforce", force);
    }
}
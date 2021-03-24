package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class ContiniousMedianSolutionTest {

    @Test
    public void addRandomNumbersOddSize() {
        ContiniousMedianSolution continiousMedianSolution = new ContiniousMedianSolution();
        for (int i = 0; i < 5; i++) {
            continiousMedianSolution.addRandomNumbers(i);
        }


        int median = continiousMedianSolution.findMedian();
        Assert.assertEquals(2, median);
        System.out.println("This is result " + median);
    }

    @Test
    public void addRandomNumbersEvenSize() {
        ContiniousMedianSolution continiousMedianSolution = new ContiniousMedianSolution();
        for (int i = 0; i < 4; i++) {
            continiousMedianSolution.addRandomNumbers(i);
        }
        int median = continiousMedianSolution.findMedian();
        Assert.assertEquals(1, median);
        System.out.println("This is result" + median);
    }
}
package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class SubSortSolutionTest {

    @Test
    public void findUnorderedSequenceTest() {
        SubSortSolution subSortSolution = new SubSortSolution();
        subSortSolution.findUnorderedSequence(getDefaultArray());
    }

    @Test
    public void findEndOfLeftSequenceTest() {
        SubSortSolution subSortSolution = new SubSortSolution();

        int endOfLeftSequence = subSortSolution.findEndOfLeftSequence(getDefaultArray());
        Assert.assertEquals(5, endOfLeftSequence);

        int endOfLeftSequence1 = subSortSolution.findEndOfLeftSequence(new int[]{1, 2, 3});
        Assert.assertEquals(2, endOfLeftSequence1);

        int endOfLeftSequence2 = subSortSolution.findEndOfLeftSequence(new int[]{1, 3, 2});
        Assert.assertEquals(1, endOfLeftSequence2);
    }

    @Test
    public void findStartOfRightSequenceTest() {
        SubSortSolution subSortSolution = new SubSortSolution();

        int endOfLeftSequence = subSortSolution.findStartOfRightSequence(getDefaultArray());
        Assert.assertEquals(8, endOfLeftSequence);

        int endOfLeftSequence1 = subSortSolution.findStartOfRightSequence(new int[]{1, 2, 3});
        Assert.assertEquals(0, endOfLeftSequence1);

        int endOfLeftSequence2 = subSortSolution.findStartOfRightSequence(new int[]{1, 3, 2});
        Assert.assertEquals(2, endOfLeftSequence2);
    }

    private int[] getDefaultArray() {
        return new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
    }
}
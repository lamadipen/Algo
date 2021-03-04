package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class TheMasseuseSolutionTest {

    @Test
    public void maxBookedMinutesTest() {
        TheMasseuseSolution theMasseuseSolution = new TheMasseuseSolution();
        int actual = theMasseuseSolution.maxBookedMinutes(new int[]{30, 15, 60, 75, 45, 15, 15, 45});

        Assert.assertEquals(180, actual); //{30,60,45,45}
    }

    @Test
    public void maxBookedMinutesMemeTest() {
        TheMasseuseSolution theMasseuseSolution = new TheMasseuseSolution();
        int actual = theMasseuseSolution.maxBookedMinutesMemo(new int[]{30, 15, 60, 75, 45, 15, 15, 45});

        Assert.assertEquals(180, actual); //{30,60,45,45}
    }

    @Test
    public void maxBookedMinutesIterativeTest() {
        TheMasseuseSolution theMasseuseSolution = new TheMasseuseSolution();
        int actual = theMasseuseSolution.maxBookedMinutesIterative(new int[]{30, 15, 60, 75, 45, 15, 15, 45});

        Assert.assertEquals(180, actual); //{30,60,45,45}
    }

    @Test
    public void maxBookedMinutesIterativeSaveSpaceTest() {
        TheMasseuseSolution theMasseuseSolution = new TheMasseuseSolution();
        int actual = theMasseuseSolution.maxBookedMinutesIterative(new int[]{30, 15, 60, 75, 45, 15, 15, 45});

        Assert.assertEquals(180, actual); //{30,60,45,45}
    }
}
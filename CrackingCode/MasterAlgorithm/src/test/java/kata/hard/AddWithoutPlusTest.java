package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class AddWithoutPlusTest {

    @Test
    public void addRecursive() {
        AddWithoutPlus addWithoutPlus = new AddWithoutPlus();
        double actual1 = addWithoutPlus.addRecursive(5, 2);
        Assert.assertEquals(7, actual1, 0.5);

        double actual2 = addWithoutPlus.addRecursive(13, 10);
        Assert.assertEquals(23, actual2, 0.5);
    }

    @Test
    public void addIterative() {
        AddWithoutPlus addWithoutPlus = new AddWithoutPlus();
        double actual1 = addWithoutPlus.addIterative(5, 2);
        Assert.assertEquals(7, actual1, 0.5);

        double actual2 = addWithoutPlus.addRecursive(13, 10);
        Assert.assertEquals(23, actual2, 0.5);
    }
}
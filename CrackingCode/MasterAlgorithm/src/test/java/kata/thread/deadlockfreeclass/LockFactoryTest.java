package kata.thread.deadlockfreeclass;

import org.junit.Assert;
import org.junit.Test;

public class LockFactoryTest {

    @Test
    public void lockFactoryTest() {
        LockFactory lockFactory = LockFactory.initialize(5);
        boolean actual1 = lockFactory.declare(1, new int[]{2, 3, 4});
        boolean actual2 = lockFactory.declare(2, new int[]{0, 1});

        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
    }


    @Test
    public void lockFactoryLocakTest() {
        LockFactory lockFactory = LockFactory.initialize(5);
        boolean actual1 = lockFactory.declare(1, new int[]{2, 3, 4});
        boolean actual2 = lockFactory.declare(2, new int[]{2, 3, 4});

        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
    }
}
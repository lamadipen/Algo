package kata.thread.callinorder.problemwithlock;

import org.junit.Test;

public class FooWithLockTest {

    @Test
    public void callInOrderTest() {
        FooWithLock foo = new FooWithLock();
        Thread t1 = new Thread(() -> foo.first());
        Thread t2 = new Thread(() -> foo.second());
        Thread t3 = new Thread(() -> foo.third());

        t1.start();
        t2.start();
        t3.start();
    }

}
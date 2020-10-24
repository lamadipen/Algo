package kata.thread.callinorder.solutionwithsemaphor;

import org.junit.Test;

public class FooWithSemaphorTest {

    @Test
    public void callInOrderTest() {
        FooWithSemaphor foo = new FooWithSemaphor();
        Thread t1 = new Thread(() -> foo.first());
        Thread t2 = new Thread(() -> foo.second());
        Thread t3 = new Thread(() -> foo.third());

        t1.start();
        t2.start();
        t3.start();
    }

}
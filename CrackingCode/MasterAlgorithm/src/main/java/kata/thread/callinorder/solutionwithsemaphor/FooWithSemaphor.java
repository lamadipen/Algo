package kata.thread.callinorder.solutionwithsemaphor;

import java.util.concurrent.Semaphore;

/**
 * Semaphore has a notion of counting, or a queue of more than one lock and unlock requests.
 * <p>
 * https://stackoverflow.com/questions/2332765/lock-mutex-semaphore-whats-the-difference
 */
public class FooWithSemaphor {
    Semaphore firstSemaphore, secondSemaphore;

    public FooWithSemaphor() {
        firstSemaphore = new Semaphore(1);
        secondSemaphore = new Semaphore(1);

        try {
            firstSemaphore.acquire();
            secondSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first() {
        firstSemaphore.release();
        System.out.println("Running first method");
    }

    public void second() {
        try {
            firstSemaphore.acquire();
            firstSemaphore.release();
            System.out.println("Running second method");
            secondSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            secondSemaphore.acquire();
            secondSemaphore.release();
            System.out.println("Running third method");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

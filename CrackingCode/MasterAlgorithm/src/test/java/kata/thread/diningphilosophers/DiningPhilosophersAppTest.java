package kata.thread.diningphilosophers;

import kata.thread.diningphilosophers.problem.Chopstick;
import kata.thread.diningphilosophers.problem.Philosopher;
import org.junit.Test;

public class DiningPhilosophersAppTest {

    @Test
    public void deadLockSituation() {
        Chopstick chopstick1 = new Chopstick();
        Chopstick chopstick2 = new Chopstick();
        Chopstick chopstick3 = new Chopstick();
        Chopstick chopstick4 = new Chopstick();

        Philosopher philosopher1 = new Philosopher("philosopher1", chopstick1, chopstick2);
        Philosopher philosopher2 = new Philosopher("philosopher2", chopstick2, chopstick3);
        Philosopher philosopher3 = new Philosopher("philosopher3", chopstick3, chopstick4);
        Philosopher philosopher4 = new Philosopher("philosopher4", chopstick4, chopstick1);

        philosopher1.start();
        philosopher4.start();
        philosopher2.start();
        philosopher3.start();

    }

}
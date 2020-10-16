package kata.thread.diningphilosophers.allornothings;

import kata.thread.diningphilosophers.problem.Chopstick;
import kata.thread.diningphilosophers.problem.Philosopher;

/**
 * All or nothing solution
 * In this solution the philosopher tires to acquire both chopstick
 * if he is unable to lock to both chopstick he will put down the
 * already picked chopstick.
 * <p>
 * This solution has 1 problem though that if all the philosophers are
 * perfectly synced then no one will be able to acquire lock on both
 * chopstick and they have to repeat the process again and again.
 */
public class AllOrNothingSolution {
    public static void main(String[] args) {
        kata.thread.diningphilosophers.problem.Chopstick chopstick1 = new kata.thread.diningphilosophers.problem.Chopstick();
        kata.thread.diningphilosophers.problem.Chopstick chopstick2 = new kata.thread.diningphilosophers.problem.Chopstick();
        kata.thread.diningphilosophers.problem.Chopstick chopstick3 = new kata.thread.diningphilosophers.problem.Chopstick();
        kata.thread.diningphilosophers.problem.Chopstick chopstick4 = new Chopstick();

        kata.thread.diningphilosophers.problem.Philosopher philosopher1 = new kata.thread.diningphilosophers.problem.Philosopher("philosopher1", chopstick1, chopstick2);
        kata.thread.diningphilosophers.problem.Philosopher philosopher2 = new kata.thread.diningphilosophers.problem.Philosopher("philosopher2", chopstick2, chopstick3);
        kata.thread.diningphilosophers.problem.Philosopher philosopher3 = new kata.thread.diningphilosophers.problem.Philosopher("philosopher3", chopstick3, chopstick4);
        kata.thread.diningphilosophers.problem.Philosopher philosopher4 = new Philosopher("philosopher4", chopstick4, chopstick1);

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
    }
}

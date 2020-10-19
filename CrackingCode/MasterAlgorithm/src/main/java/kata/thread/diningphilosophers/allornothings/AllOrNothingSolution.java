package kata.thread.diningphilosophers.allornothings;


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
        Chopstick chopstick1 = new Chopstick();
        Chopstick chopstick2 = new Chopstick();
        Chopstick chopstick3 = new Chopstick();
        Chopstick chopstick4 = new Chopstick();

        Philosopher philosopher1 = new Philosopher("philosopher1", chopstick1, chopstick2);
        Philosopher philosopher2 = new Philosopher("philosopher2", chopstick2, chopstick3);
        Philosopher philosopher3 = new Philosopher("philosopher3", chopstick3, chopstick4);
        Philosopher philosopher4 = new Philosopher("philosopher4", chopstick4, chopstick1);

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
    }
}

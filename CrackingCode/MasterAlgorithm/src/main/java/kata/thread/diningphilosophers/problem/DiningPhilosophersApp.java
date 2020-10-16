package kata.thread.diningphilosophers.problem;

public class DiningPhilosophersApp {
    /**
     * Run the app multiple times to create dead lock situation
     * You will see that console will not be printing any output and program
     * also doesn't ends when there is dead lock.
     * <p>
     * Dead lock happens if all the philosophers pick left chopstick at same
     * time and waiting for the right one.
     */
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

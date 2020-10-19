package kata.thread.diningphilosophers.prioritizedChopstic;


public class PrioritizedChopstickSolution {
    /**
     * Prioritized Chopstick Solution
     * In this solution each the philosopher tires to acquire lower chopstick
     * first (left chopstick) before higher (right chopstick), excepth the
     * last philosopher who does this in reverse, breaking the cycle.
     * <p>
     */
    public static void main(String[] args) {
        Chopstick chopstick1 = new Chopstick(1);
        Chopstick chopstick2 = new Chopstick(2);
        Chopstick chopstick3 = new Chopstick(3);
        Chopstick chopstick4 = new Chopstick(4);

        Philosopher philosopher1 = new Philosopher("philosopher1", chopstick1, chopstick2);
        Philosopher philosopher2 = new Philosopher("philosopher2", chopstick2, chopstick3);
        Philosopher philosopher3 = new Philosopher("philosopher3", chopstick3, chopstick4);
        Philosopher philosopher4 = new Philosopher("philosopher4", chopstick1, chopstick4);

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
    }
}

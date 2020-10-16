package kata.thread.diningphilosophers.problem;

public class Philosopher extends Thread {
    public Chopstick left, right;
    public int bites = 10;
    public String name;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    private void pickUp() {
        left.pickup();
        right.pickup();
    }

    private void putDown() {
        right.putDown();
        left.putDown();
    }

    private void chew() {
        System.out.println(name + " Chewing food");
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}

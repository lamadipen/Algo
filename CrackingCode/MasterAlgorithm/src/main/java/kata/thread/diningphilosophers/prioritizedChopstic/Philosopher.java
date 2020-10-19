package kata.thread.diningphilosophers.prioritizedChopstic;

public class Philosopher extends Thread {
    Chopstick higher, lower;
    int bites = 10;
    String name;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.name = name;
        if (left.number < right.number) {
            this.higher = right;
            this.lower = left;
        } else {
            this.higher = left;
            this.lower = right;
        }
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    private void putDown() {
        higher.putDown();
        lower.putDown();
    }

    private void chew() {
        System.out.println(name + " Chewing food");
    }

    private void pickUp() {
        lower.pickUp();
        higher.pickUp();
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}

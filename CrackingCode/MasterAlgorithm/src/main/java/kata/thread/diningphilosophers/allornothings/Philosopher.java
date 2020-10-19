package kata.thread.diningphilosophers.allornothings;

public class Philosopher extends Thread {
    int bites = 10;
    Chopstick left, right;
    String name;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    private void putDown() {
        right.putDown();
        left.putDown();
    }

    private void chew() {
        System.out.println(name + " Chewing");
    }

    private boolean pickUp() {
        if (!left.pickUp()) {
            return false;
        }
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}

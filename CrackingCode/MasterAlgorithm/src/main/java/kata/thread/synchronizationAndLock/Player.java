package kata.thread.synchronizationAndLock;

public class Player extends Thread {
    private String name;
    private Weapon weapon;

    public Player(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    @Override
    public void run() {
        weapon.fire(name);
    }
}

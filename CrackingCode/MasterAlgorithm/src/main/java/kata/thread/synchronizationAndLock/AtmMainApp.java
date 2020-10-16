package kata.thread.synchronizationAndLock;

public class AtmMainApp {

    public static void main(String[] args) {
        LockAtm atm = new LockAtm();

        AtmUser atmUser1 = new AtmUser(atm);
        AtmUser atmUser2 = new AtmUser(atm);

        Thread thread1 = new Thread(() -> atmUser1.atm.deposit(100));
        Thread thread2 = new Thread(() -> atmUser2.atm.withDraw(200));

        thread1.start();
        thread2.start();
    }
}

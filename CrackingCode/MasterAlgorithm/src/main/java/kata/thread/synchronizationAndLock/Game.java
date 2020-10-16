package kata.thread.synchronizationAndLock;

public class Game {

    public static void main(String[] args) {
        Weapon gun = new Weapon();
        Weapon rod = new Weapon();

        /**
         * For different reference both thread can call weapon.fire()
         * as there is no shared object reference
         * */
        Player player1 = new Player("Player1", gun);
        Player player2 = new Player("Player2", rod);

        player1.start();
        player2.start();

        /**
         * For Same shared reference only one will be allowed to call weapon.fire()
         * The one of the player will wait till the shared resource is available.
         * The execution will happen in sequencial manner
         * */
        Weapon nuke = new Weapon();
        Player player3 = new Player("Player3", nuke);
        Player player4 = new Player("Player4", nuke);

        player3.start();
        player4.start();

    }
}

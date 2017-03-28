package hrank.interfaeExample;

/**
 * Created by dipen on 3/4/2017.
 */
public class Enemy implements Character{
    @Override
    public void attack() {
        System.out.println("Enemy attacking");
    }

    @Override
    public void heal() {
        System.out.println("Enemy healing");
    }
}

package hrank.interfaeExample;

/**
 * Created by dipen on 3/4/2017.
 */
public class Hero implements Character{
    @Override
    public void attack() {
        System.out.println("Hero attacking");
    }

    @Override
    public void heal() {
        System.out.println("Hero healing");
    }
}

package hrank.exception;

/**
 * Created by dipen on 3/1/2017.
 */
public class HotChocolate {

    public static final double tooHot = 185;
    public static final double tooCold = 160;

    public static  void drinkHotChocolate(double cocaTemp) throws TooHotException, TooColdException
    {
        if(cocaTemp >= tooHot)
        {
            throw  new TooHotException();
        }
        else if(cocaTemp <= tooCold)
        {
            throw  new TooColdException();
        }
    }
    public static void main(String [] args)
    {
        double currentCocaTemp = 150;

        try {
            drinkHotChocolate(currentCocaTemp);
            System.out.println("It's good");
        }catch (TooHotException e){
            System.out.println("Too Hot");
        }catch (TooColdException e){
            System.out.println("Too Cold");
        }

        System.out.println("Complete");
    }
}

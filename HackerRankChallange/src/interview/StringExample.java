package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dipen on 3/16/2017.
 */
public class StringExample{


    public static void main(String [] args)
    {
        String test = new String("Dipen");
        String test1 = "Dipen";
        String test2 = test;

        if(test1 == test2)
        {
            System.out.println("Is equal using ==");
        }
        if(test1.equals(test2))
        {
            System.out.println("Is equal using equals");
        }


        //What is the output of below program?
        String s1 = new String("pankaj");
        String s2 = new String("PANKAJ");
        System.out.println(s1 = s2);

    }
}

package hrank.interfaeExample;

import java.util.Random;

/**
 * Created by dipen on 3/4/2017.
 */
public class StarWarInterfacePractice {

    public static void main(String [] args)
    {
        Character sChar = summonCharacter();
        sChar.attack();
        sChar.heal();
    }

    public static Character summonCharacter()
    {
        Random rand = new Random();

        if(Math.abs(rand.nextInt())%2==0){
            return new Hero();
        }else {
            return new Enemy();
        }

    }
}

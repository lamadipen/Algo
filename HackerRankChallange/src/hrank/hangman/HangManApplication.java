package hrank.hangman;
import java.util.Scanner;

/**
 * Created by dipen on 3/9/2017.
 */
public class HangManApplication {

    public static  void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcom to hangman. I will pick a word" +
                "and you try to guess. IF you guess wrong 6 time i Win other wise you win");
        System.out.println();
        System.out.println("I have picked my word. what is your current guess");

        boolean doYouWanttoPlay = true;

        while(doYouWanttoPlay)
        {
            /*while(!game.gameOver)
            {

            }*/
            System.out.println();
            System.out.println("Do you want to play anothe game? Enter Y if you do");
            Character response = (sc.next().toUpperCase().charAt(0));
        }
    }

}

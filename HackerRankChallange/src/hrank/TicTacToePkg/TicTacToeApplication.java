package hrank.TicTacToePkg;

import java.util.Scanner;

/**
 * Created by dipen on 3/15/2017.
 */
public class TicTacToeApplication {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;
        while(doYouWantToPlay)
        {
            System.out.println("WelCome to Tic Tac Toe! Pick you character and Enemy charicter");
            System.out.println();
            System.out.println("Enter a single character for you");
            char playerToken =sc.next().charAt(0);
            System.out.println("Enter a single character for opponent");
            char opponentToken =sc.next().charAt(0);
            TicTacToe tc = new TicTacToe(playerToken,opponentToken);
            AI ai= new AI();

            //setup the game
            System.out.println("Select your choice from 1-9");
            tc.printBoardIndex();
            while (tc.gameOver().equals("Not over"))
            {
                if(tc.currentMarker == tc.userMarker)
                {
                    System.out.println("Its your turn");
                    int spot =sc.nextInt();
                    while(!tc.playTurn(spot))
                    {
                        System.out.println("Select Another Choice!");
                        spot =sc.nextInt();
                    }
                    System.out.println("You picked"+spot+" !");
                }
                else {
                    System.out.println("AI turn");
                    int aiSpot =ai.pickSpot(tc);
                    tc.playTurn(aiSpot);
                    System.out.println("AI picked"+aiSpot+" !");
                }
                System.out.println();
                tc.printBoard();
            }
            System.out.println(tc.gameOver());
            System.out.println();
            System.out.println("Do you want to play again");

            char response= sc.next().charAt(0);
            doYouWantToPlay = (response =='y');
            System.out.println();
            System.out.println();
        }

    }
}

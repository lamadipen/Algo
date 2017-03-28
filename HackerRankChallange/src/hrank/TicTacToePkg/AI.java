package hrank.TicTacToePkg;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dipen on 3/15/2017.
 */
public class AI {

    public int pickSpot(TicTacToe game)
    {
        ArrayList<Integer> choices = new ArrayList<>();
        for(int i=0; i < 9;i++)
        {
            //if the slot is not taken add it as a choice
            if(game.board[i]=='-')
            {
                choices.add(i+1);
            }
        }
        Random rand = new Random();
        int choice = choices.get(Math.abs(rand.nextInt()%choices.size()));
        return  choice;
    }
}

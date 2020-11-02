package kata.moderate.TicTacWin;

import org.junit.Assert;
import org.junit.Test;

public class Solution3By3BoardTest {

    @Test
    public void canFindWinnerInRow() {
        Solution3By3Board solution3By3Board = new Solution3By3Board();

        Piece[][] pieces = {
                {Piece.BLUE, Piece.EMPTY, Piece.RED},
                {Piece.BLUE, Piece.BLUE, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.RED},
        };
        Piece winner = solution3By3Board.isWinner(pieces);

        Assert.assertEquals(Piece.BLUE, winner);
    }

    @Test
    public void canFindWinnerInColumn() {
        Solution3By3Board solution3By3Board = new Solution3By3Board();

        Piece[][] pieces = {
                {Piece.BLUE, Piece.EMPTY, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.RED},
        };
        Piece winner = solution3By3Board.isWinner(pieces);

        Assert.assertEquals(Piece.BLUE, winner);
    }

    @Test
    public void canFindWinnerInDiagonal1() {
        Solution3By3Board solution3By3Board = new Solution3By3Board();

        Piece[][] pieces = {
                {Piece.RED, Piece.EMPTY, Piece.RED},
                {Piece.EMPTY, Piece.RED, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.RED},
        };
        Piece winner = solution3By3Board.isWinner(pieces);

        Assert.assertEquals(Piece.RED, winner);
    }

    @Test
    public void canFindWinnerInDiagonal2() {
        Solution3By3Board solution3By3Board = new Solution3By3Board();

        Piece[][] pieces = {
                {Piece.BLUE, Piece.EMPTY, Piece.RED},
                {Piece.EMPTY, Piece.RED, Piece.BLUE},
                {Piece.RED, Piece.EMPTY, Piece.RED},
        };
        Piece winner = solution3By3Board.isWinner(pieces);
        Assert.assertEquals(Piece.RED, winner);
    }

}
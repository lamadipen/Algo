package kata.moderate;

import org.junit.Test;

import java.util.HashSet;

public class DividingBoardTest {

    @Test
    public void getLengthOfBoardTest() {
        DividingBoard dividingBoard = new DividingBoard();

        HashSet<Integer> lengthOfBoard = dividingBoard.getLengthOfBoard(5, 2, 4);
        for (Integer integer : lengthOfBoard) {
            System.out.println(integer);
        }
    }

    @Test
    public void getLengthOfBoardTestWithSimpleInput() {
        DividingBoard dividingBoard = new DividingBoard();

        HashSet<Integer> lengthOfBoard = dividingBoard.getLengthOfBoard(3, 1, 2);
        for (Integer integer : lengthOfBoard) {
            System.out.println(integer);
        }
    }

    @Test
    public void getLengthOfBoardTestWithMemoization() {
        DividingBoard dividingBoard = new DividingBoard();

        HashSet<Integer> lengthOfBoard = dividingBoard.getLengthOfBoardMemoization(3, 1, 2);
        for (Integer integer : lengthOfBoard) {
            System.out.println(integer);
        }
    }

    @Test
    public void getLengthOfBoardTestWithOptimalSoluiton() {
        DividingBoard dividingBoard = new DividingBoard();

        HashSet<Integer> lengthOfBoard = dividingBoard.
                getLengthOfBoardOptimalSolution(3, 1, 2);
        for (Integer integer : lengthOfBoard) {
            System.out.println(integer);
        }
    }
}
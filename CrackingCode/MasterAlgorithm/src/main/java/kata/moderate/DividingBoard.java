package kata.moderate;

import java.util.HashSet;

/**
 * Moderate
 * Dividing Board
 * CC: pg 182 Q: 16.11
 */
public class DividingBoard {
    /**
     * Runtime
     * O(2^n)
     */
    public HashSet<Integer> getLengthOfBoard(int numberOfBoard, int smallBoardLength, int bigBoardLength) {
        HashSet<Integer> lengths = new HashSet<>();
        getAllLengths(numberOfBoard, 0, smallBoardLength, bigBoardLength, lengths);
        return lengths;
    }

    private void getAllLengths(int numberOfBoard, int total, int smallBoardLength, int bigBoardLength, HashSet<Integer> lengths) {
        if (numberOfBoard == 0) {
            lengths.add(total);
            return;
        }
        getAllLengths(numberOfBoard - 1, total + smallBoardLength, smallBoardLength, bigBoardLength, lengths);
        getAllLengths(numberOfBoard - 1, total + bigBoardLength, smallBoardLength, bigBoardLength, lengths);
    }


    public HashSet<Integer> getLengthOfBoardMemoization(int numberOfBoard, int smallBoardLength, int bigBoardLength) {
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        getAllLengthsMemoization(numberOfBoard, 0, smallBoardLength, bigBoardLength, lengths, visited);
        return lengths;
    }

    private void getAllLengthsMemoization(int numberOfBoard, int total, int smallBoardLength, int bigBoardLength, HashSet<Integer> lengths, HashSet<String> visited) {
        if (numberOfBoard == 0) {
            lengths.add(total);
            return;
        }
        String key = numberOfBoard + " " + total;
        if (visited.contains(key)) {
            return;
        }
        getAllLengthsMemoization(numberOfBoard - 1, total + smallBoardLength, smallBoardLength, bigBoardLength, lengths, visited);
        getAllLengthsMemoization(numberOfBoard - 1, total + bigBoardLength, smallBoardLength, bigBoardLength, lengths, visited);
        visited.add(key);
    }


    public HashSet<Integer> getLengthOfBoardOptimalSolution(int numberOfBoard, int smallBoardLength, int bigBoardLength) {
        HashSet<Integer> lengths = new HashSet<>();

        for (int nShort = 0; nShort <= numberOfBoard; nShort++) {
            int nLonger = numberOfBoard - nShort;
            int length = nShort * smallBoardLength + nLonger * bigBoardLength;
            lengths.add(length);
        }
        return lengths;
    }

}

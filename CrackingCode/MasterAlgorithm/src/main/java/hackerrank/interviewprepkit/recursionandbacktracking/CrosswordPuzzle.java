package hackerrank.interviewprepkit.recursionandbacktracking;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Interview Preparation Kit | Recursion And Backtracking | Crossword Puzzle
 * Common Child
 */
public class CrosswordPuzzle {

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        // Write your code here
        char[][] crosswordsArray = crossword
                .stream()
                .limit(10)
                .map(String::toCharArray)
                .toArray(char[][]::new);

        final char[][] wordsArray = Arrays
                .stream(words.split(";"))
                .map(String::toCharArray)
                .toArray(char[][]::new);

        final char[][] result = solve(crosswordsArray, wordsArray, 0, new AtomicBoolean());

        Arrays
                .stream(result)
                .map(String::new)
                .forEach(System.out::println);

        return null;
    }

    static char[][] solve(final char[][] crosswordArray, final char[][] wordsArray, final int numberOfWords, final AtomicBoolean found) {
        if (numberOfWords == wordsArray.length) {
            found.set(true);
            return crosswordArray;
        }

        final int wordLength = wordsArray[numberOfWords].length;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                int fillableCellRow = 0, fillableCellCol = 0;

                for (int i = col; i < 10 && fillableCellRow < wordLength && (wordsArray[numberOfWords][fillableCellRow] == crosswordArray[row][i] || crosswordArray[row][i] == '-'); i++, fillableCellRow++) {
                }
                for (int i = row; i < 10 && fillableCellCol < wordLength && (wordsArray[numberOfWords][fillableCellCol] == crosswordArray[i][col] || crosswordArray[i][col] == '-'); i++, fillableCellCol++) {
                }

                if (fillableCellRow == wordLength) {
                    final char[][] tempCrossWord = Arrays.stream(crosswordArray).map(char[]::clone).toArray(char[][]::new);
                    System.arraycopy(wordsArray[numberOfWords], 0, tempCrossWord[row], col, wordLength);
                    final char solvedCrossword[][] = solve(tempCrossWord, wordsArray, numberOfWords + 1, found);
                    if (found.get()) {
                        return solvedCrossword;
                    }
                }

                if (fillableCellCol == wordLength) {
                    final char[][] tempCrossWord = Arrays.stream(crosswordArray).map(char[]::clone).toArray(char[][]::new);
                    for (int i = 0; i < wordLength; tempCrossWord[row + i][col] = wordsArray[numberOfWords][i], i++) {
                    }

                    final char solvedCrossword[][] = solve(tempCrossWord, wordsArray, numberOfWords + 1, found);
                    if (found.get()) {
                        return solvedCrossword;
                    }
                }
            }
        }
        return crosswordArray;
    }

    public static char[][] solveCrosswordHR(char[][] crossword, char[][] words, int noOfWord, AtomicBoolean found) {
        if (noOfWord == words.length) {
            found.set(true);
            return crossword;
        }

        int wordLength = words[noOfWord].length;

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {

                int fillableRow = 0;
                int fillableCol = 0;

                for (int i = col; i < 10 && fillableRow < wordLength && (crossword[row][i] == words[noOfWord][fillableRow] || crossword[row][i] == '-'); fillableRow++, i++) {
                }

                for (int j = row; j < 10 && fillableCol < wordLength && (crossword[j][col] == words[noOfWord][fillableCol] || crossword[j][col] == '-'); fillableCol++, j++) {
                }

                if (fillableRow == wordLength) {
                    char[][] tempCrossword = Arrays.stream(crossword).map(char[]::clone).toArray(char[][]::new);
                    System.arraycopy(words[noOfWord], 0, tempCrossword[row], col, wordLength);
                    char[][] solvedCrossword = solveCrosswordHR(tempCrossword, words, noOfWord + 1, found);

                    if (found.get()) {
                        return solvedCrossword;
                    }
                }

                if (fillableCol == wordLength) {
                    char[][] tempCrossword = Arrays.stream(crossword).map(char[]::clone).toArray(char[][]::new);
                    for (int i = 0; i < wordLength; tempCrossword[row + i][col] = words[noOfWord][i], i++) {
                    }
                    char[][] solvedCrossword = solveCrosswordHR(tempCrossword, words, noOfWord + 1, found);

                    if (found.get()) {
                        return solvedCrossword;
                    }
                }
            }
        }
        return crossword;
    }
}

package hackerrank.interviewprepkit.recursionandbacktracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CrosswordPuzzleTest {

    @Test
    public void crosswordPuzzle1() {
        String words = "POLAND;LHASA;SPAIN;INDIA";

        List<String> puzzle = Arrays.asList(
                "++++++++++",
                "+------+++",
                "+++-++++++",
                "+++-++++++",
                "+++-----++",
                "+++-++-+++",
                "++++++-+++",
                "++++++-+++",
                "++++++-+++",
                "++++++++++"
        );


        CrosswordPuzzle.crosswordPuzzle(puzzle, words);
    }


    @Test
    public void crosswordPuzzle2() {
        String words = "LONDON;DELHI;ICELAND;ANKARA";

        List<String> puzzle = Arrays.asList(
                "+-++++++++",
                "+-++++++++",
                "+-++++++++",
                "+-----++++",
                "+-+++-++++",
                "+-+++-++++",
                "+++++-++++",
                "++------++",
                "+++++-++++",
                "+++++-++++"
        );


        CrosswordPuzzle.crosswordPuzzle(puzzle, words);
    }
}
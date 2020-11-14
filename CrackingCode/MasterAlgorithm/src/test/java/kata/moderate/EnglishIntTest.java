package kata.moderate;

import org.junit.Test;

public class EnglishIntTest {

    @Test
    public void printEnglishIntMySolutionTest() {
        EnglishInt englishInt = new EnglishInt();
        englishInt.printEnglishInt(2200);
    }

    @Test
    public void printEnglishIntTest() {
        EnglishInt englishInt = new EnglishInt();
        String actual = englishInt.convert(91200);
        System.out.println(actual);
    }

    @Test
    public void printEnglishIntBookSolutionTest() {
        EnglishInt.BookSolution bookSolution = new EnglishInt.BookSolution();
        String actual = bookSolution.convert(91200);
        System.out.println(actual);
    }

    @Test
    public void printEnglishIntTestDevSolution() {
        EnglishInt englishInt = new EnglishInt();
        String actual = englishInt.deviSolution(191000);
        System.out.println(actual);

    }
}
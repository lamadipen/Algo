package kata.hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BabyNamesTest {

    @Test
    public void trulyMostPopular() {
        BabyNames babyNames = new BabyNames();
        Map<String, Integer> names = new HashMap<>();
        names.put("john", 15);
        names.put("jon", 12);
        names.put("chris", 13);
        names.put("kris", 4);
        names.put("christopher", 19);

        String[][] synonyms = new String[4][2];
        synonyms[0] = new String[]{"jon", "john"};
        synonyms[1] = new String[]{"john", "jonny"};
        synonyms[2] = new String[]{"chris", "kris"};
        synonyms[3] = new String[]{"chris", "christopher"};

        Map<String, Integer> actual = babyNames.trulyMostPopular(names, synonyms);
        actual.forEach((s, integer) -> System.out.println("Name : " + s + " freq : " + integer));
    }

    @Test
    public void trulyMostPopularOptimized() {
        BabyNames babyNames = new BabyNames();
        Map<String, Integer> names = new HashMap<>();
        names.put("john", 15);
        names.put("jon", 12);
        names.put("chris", 13);
        names.put("kris", 4);
        names.put("christopher", 19);

        String[][] synonyms = new String[4][2];
        synonyms[0] = new String[]{"jon", "john"};
        synonyms[1] = new String[]{"john", "jonny"};
        synonyms[2] = new String[]{"chris", "kris"};
        synonyms[3] = new String[]{"chris", "christopher"};

        Map<String, Integer> actual = babyNames.trulyMostPopularOptimized(names, synonyms);
        actual.forEach((s, integer) -> System.out.println("Name : " + s + " freq : " + integer));
    }
}
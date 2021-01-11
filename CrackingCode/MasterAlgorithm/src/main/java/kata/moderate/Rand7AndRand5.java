package kata.moderate;


import java.util.*;

/**
 * Moderate
 * Rand7 And Rand5
 * CC: pg 185 Q: 16.23
 */
public class Rand7AndRand5 {
    Set<Integer> possibleValues = new HashSet<>();
    Map<Integer, Integer> valueCount = new HashMap<>();

    public int rand7() {
        while (true) {
            int value = rand5() * 5 + rand5();
            if (value < 21) {
                possibleValues.add(value);
                int key = value % 7;
                valueCount.putIfAbsent(key, 1);
                valueCount.computeIfPresent(key, (k, v) -> v + 1);
                return value % 7;
            }

            if (possibleValues.size() >= 21) {
                break;
            }
        }

//        possibleValues.forEach(System.out::println);

        valueCount.forEach((k, v) -> System.out.println(k + " ->" + v));
        return 0;
    }

    public int rand5() {
        Random random = new Random();
        return random.nextInt(5);
    }
}

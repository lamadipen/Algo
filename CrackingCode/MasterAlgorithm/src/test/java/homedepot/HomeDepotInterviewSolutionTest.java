package homedepot;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeDepotInterviewSolutionTest {

    @Test
    public void higestOrderTest1() {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("This", 2);
        expected.put("is", 2);
        expected.put("test", 2);
        expected.put("string", 1);
        expected.put("and", 1);
        expected.put("the", 1);
        expected.put("display", 1);
        expected.put("words", 1);
        expected.put("in", 1);
        expected.put("descending", 1);
        expected.put("order", 1);
        expected.put("of", 1);
        expected.put("their", 1);
        expected.put("occurrence", 1);

        Map<String, Integer> actual = HomeDepotInterviewSolution.higestOrder("This is a test string and this test is to display the words in descending order of their occurrence");
        Assert.assertNotNull(actual);
        Integer thisCount = actual.get("this");
        Assert.assertEquals(java.util.Optional.ofNullable(2), java.util.Optional.ofNullable(thisCount));

        System.out.println("actual = " + actual);
    }

    @Test
    public void higestOrderTest2() {
        Map<String, Integer> actual = HomeDepotInterviewSolution.higestOrder(null);
        Assert.assertNull(actual);
    }

    @Test
    public void test() {
        Map<Character, Integer> count = new HashMap<>();
        count.put('a', 2);
        count.put('d', 1);
        count.put('c', 10);
        count.put('f', 20);

        LinkedHashMap<Character, Integer> result = count
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("result = " + result);
    }
}
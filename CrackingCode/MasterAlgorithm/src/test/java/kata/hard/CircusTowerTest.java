package kata.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CircusTowerTest {

    @Test
    public void longestIncreasingSequence() {
        CircusTower circusTower = new CircusTower();
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(65, 100));
        persons.add(new Person(70, 150));
        persons.add(new Person(56, 90));
        persons.add(new Person(75, 190));
        persons.add(new Person(60, 95));
        persons.add(new Person(68, 110));
        List<Person> actual = circusTower.longestIncreasingSequence(persons);

        ArrayList<Person> expected = new ArrayList<>();
        expected.add(new Person(56, 90));
        expected.add(new Person(60, 95));
        expected.add(new Person(65, 100));
        expected.add(new Person(68, 110));
        expected.add(new Person(70, 150));
        expected.add(new Person(75, 190));

        Assert.assertTrue(expected.equals(actual));
    }
}
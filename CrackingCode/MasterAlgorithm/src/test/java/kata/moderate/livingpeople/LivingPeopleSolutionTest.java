package kata.moderate.livingpeople;

import org.junit.Assert;
import org.junit.Test;

public class LivingPeopleSolutionTest {

    LivingPeopleSolution livingPeopleSolution = new LivingPeopleSolution();

    @Test
    public void maxAliveYearTest() {
        Person[] people = {new Person(1900, 1902), new Person(1901, 1902), new Person(1901, 1904), new Person(1903, 1904)};
        int actual = livingPeopleSolution.maxAliveYear(people, 1900, 1904);
        Assert.assertEquals(1901, actual);
    }

    @Test
    public void maxAliveYearImprovement1Test() {
        Person[] people = {new Person(1900, 1902), new Person(1901, 1902), new Person(1901, 1904), new Person(1903, 1904)};
        int actual = livingPeopleSolution.maxAliveYearImprovement1(people, 1900, 1904);
        Assert.assertEquals(1901, actual);
    }

    @Test
    public void maxAliveYearImprovement2Test() {
        Person[] people = {new Person(1900, 1902), new Person(1901, 1902), new Person(1901, 1904), new Person(1903, 1904)};
        int actual = livingPeopleSolution.maxAliveYearImprovement2(people, 1900, 1904);
        Assert.assertEquals(1901, actual);
    }
}
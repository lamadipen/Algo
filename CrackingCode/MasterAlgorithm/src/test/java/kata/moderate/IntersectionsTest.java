package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class IntersectionsTest {

    @Test
    public void findIntersection() {

        Intersections intersections = new Intersections();
        Point actual = intersections.findIntersection(new Point(3, -2), new Point(-1, 1), new Point(-2, -3), new Point(2, 4));

        Assert.assertNotNull(actual);
    }
}
package kata.recursiondynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PowerSetTest {

    @Test
    public void getAllSubSetsRecursive() {
        List<Integer> set = Arrays.asList(new Integer[]{2, 3, 4});
        PowerSet powerset = new PowerSet();
        List<List<Integer>> allSubSets = powerset.getAllSubSetsRecursive(set, 0);

        Assert.assertEquals(8, allSubSets.size());

        for (List<Integer> subset : allSubSets) {
            System.out.println(Arrays.toString(subset.toArray()));
        }
    }

    @Test
    public void getAllSubSetsIterative() {

        List<Integer> set = Arrays.asList(new Integer[]{2, 3, 4});
        System.err.println(1 << 3);
//        PowerSet powerset = new PowerSet();
//        List<List<Integer>> allSubSets = powerset.getAllSubSetsRecursive(set, 0);
//
//        Assert.assertEquals(8, allSubSets.size());
//
//        for (List<Integer> subset : allSubSets) {
//            System.out.println(Arrays.toString(subset.toArray()));
//        }
    }
}
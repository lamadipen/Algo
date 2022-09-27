package metaprep.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairWithGivenSumInASortedArraySolutionTest {

    @Test
    void countPairsTest1() {
        int actual = PairWithGivenSumInASortedArraySolution.countPairs(new int[]{1, 2, 3, 4, 5, 6, 7},8);
        Assertions.assertEquals(3,actual);
    }

    @Test
    void countPairsTest2() {
        int actual = PairWithGivenSumInASortedArraySolution.countPairs(new int[]{1, 2, 3, 4, 5, 6, 7},98);
        Assertions.assertEquals(0,actual);
    }
}
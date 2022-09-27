package metaprep.hashtables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheSolutionTest {

    @Test
    void get() {
        LRUCacheSolution lruCacheSolution = new LRUCacheSolution(2);
        lruCacheSolution.set(1,2);
        lruCacheSolution.set(2,3);
        lruCacheSolution.set(1,5);
        lruCacheSolution.set(4,5);
        lruCacheSolution.set(6,7);
        int result1 = lruCacheSolution.get(4);
        Assertions.assertEquals(5,result1);
        lruCacheSolution.set(1,2);
        int result2 = lruCacheSolution.get(3);
        Assertions.assertEquals(-1,result2);
    }

    @Test
    void set() {
    }
}
package kata.recursiondynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class MagicIndexTest {
    @Test
    public void getMagicIndexBruteForceTest() {
        int[] array = {-2, -1, 1, 2, 3, 5, 7, 8};
        MagicIndex magicIndex = new MagicIndex();
        int actual = magicIndex.getMagicIndexBruteForce(array);

        Assert.assertEquals(5, actual);
    }

    @Test
    public void getMagicIndexOptimizedTest() {
        int[] array = {-2, -1, 1, 2, 3, 5, 7, 8};
        MagicIndex magicIndex = new MagicIndex();
        int actual = magicIndex.getMagicIndexOptimized(array);

        Assert.assertEquals(5, actual);
    }

    @Test
    public void getMagicIndexHandleDuplicateOptimizedTest() {
        int[] array = {-2, -1, 1, 5, 5, 5, 5, 8};
        MagicIndex magicIndex = new MagicIndex();
        int actual = magicIndex.getMagicIndexHandleDuplicateOptimized(array);

        Assert.assertEquals(5, actual);
    }

}
package kata.treeandgraph.pathwithsum;

import kata.treeandgraph.MockTreeFactory;
import kata.treeandgraph.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class PathWithSumTest {

    @Test
    public void pathWithSumTestWithNullRoot() {
        PathWithSum pathWithSum = new PathWithSum();

        int expected = pathWithSum.countPathWithSum(null, 8);
        Assert.assertEquals(0, expected);
    }

    @Test
    public void pathWithSumTest() {
        PathWithSum pathWithSum = new PathWithSum();

        TreeNode root = MockTreeFactory.getMockForPathWithSumTreeRoot();

        int expected = pathWithSum.countPathWithSum(root, 8);

        Assert.assertEquals(2, expected);
    }


    @Test
    public void pathWithSumOptimizedTest() {
        PathWithSum pathWithSum = new PathWithSum();

        TreeNode root = MockTreeFactory.getMockForPathWithSumTreeRoot();

        int expected = pathWithSum.countPathWithSumOptimized(root, 8);

        Assert.assertEquals(3, expected);
    }
}
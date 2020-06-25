package kata.treeandgraph;

import org.junit.Assert;
import org.junit.Test;

public class CheckSubTreeTest {

    @Test
    public void isSubTreeTest() {
        CheckSubTree checkSubTree = new CheckSubTree();

        TreeNode node1 = MockTreeFactory.getMockTreeRoot();
        TreeNode node2 = node1.left;
        boolean isSubtree = checkSubTree.isSubTree(node1, node2);

        Assert.assertTrue(isSubtree);
    }

    @Test
    public void isSubTreeAlternativeTest() {
        CheckSubTree checkSubTree = new CheckSubTree();

        TreeNode node1 = MockTreeFactory.getMockTreeRoot();
        TreeNode node2 = node1.left;
        boolean isSubtree = checkSubTree.isSubTreeAlternative(node1, node2);

        Assert.assertTrue(isSubtree);
    }


}
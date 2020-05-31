package kata.treeandgraph;

import org.junit.Assert;
import org.junit.Test;

public class MinimalTreeTest {

    @Test
    public void minimalTreeTest() {
        MinimalTree minimalTree = new MinimalTree();
        TreeNode root = minimalTree.create(new int[]{1, 2, 3, 4, 5, 6, 7});


        Assert.assertEquals(4, root.data);
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.traverse(root);
    }

}
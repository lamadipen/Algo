package kata.treeandgraph;

import org.junit.Test;

public class PreOrderTraversalTest {

    @Test
    public void preOrderTraversal() {
        TreeNode mockTreeRoot = MockTreeFactory.getMockTreeRoot();

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.traverse(mockTreeRoot);

        //5 should be in the start as current node is visited first
    }
}
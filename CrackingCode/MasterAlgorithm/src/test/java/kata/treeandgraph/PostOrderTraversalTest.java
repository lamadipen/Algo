package kata.treeandgraph;

import org.junit.Test;

public class PostOrderTraversalTest {

    @Test
    public void postOrderTraversalTest() {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        TreeNode mockTreeRoot = MockTreeFactory.getMockTreeRoot();
        postOrderTraversal.traverse(mockTreeRoot);

        //5 should be last element as its the root
    }

}
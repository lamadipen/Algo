package kata.treeandgraph;

import org.junit.Test;

public class InorderTraversalTest {

    @Test
    public void inorderTraversalTest(){
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        TreeNode mockTreeRoot = MockTreeFactory.getMockTreeRoot();
        inOrderTraversal.traverse(mockTreeRoot);

        //left most element must be on the first as left most node is visited first
    }

}

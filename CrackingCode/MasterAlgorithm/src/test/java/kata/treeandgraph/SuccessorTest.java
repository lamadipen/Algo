package kata.treeandgraph;

import org.junit.Assert;
import org.junit.Test;

public class SuccessorTest {

    @Test
    public void getSuccessorTest() {
        //After inorder traversal
        //[1,2,3,4,7,8,9]
        Successor successor = new Successor();
        TreeNode treeRoot = MockTreeFactory.getMockWithSuccessorTreeRoot();

        TreeNode actualSuccessor7 = successor.getSuccessor(treeRoot);
        Assert.assertEquals(7, actualSuccessor7.data);

        TreeNode actualSuccessor2 = successor.getSuccessor(treeRoot.left.left);
        Assert.assertEquals(2, actualSuccessor2.data);

        TreeNode actualSuccessor9 = successor.getSuccessor(treeRoot.right);
        Assert.assertEquals(9, actualSuccessor9.data);

        TreeNode actualSuccessorNull = successor.getSuccessor(treeRoot.right.right);
        Assert.assertNull(actualSuccessorNull);
    }
}

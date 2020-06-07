package kata.treeandgraph;

import org.junit.Assert;
import org.junit.Test;

public class ValidBSTTest {

    @Test
    public void isValidTestShouldReturnTrue() {

        TreeNode mockBSTTreeRoot = MockTreeFactory.getMockBSTTreeRoot();
        ValidBST validBST = new ValidBST();

        Assert.assertTrue(validBST.isValidBST(mockBSTTreeRoot));
    }

    @Test
    public void isValidTestShouldReturnFalse() {

        TreeNode mockBSTTreeRoot = MockTreeFactory.getMockNotBSTTreeRoot();
        ValidBST validBST = new ValidBST();

        Assert.assertFalse(validBST.isValidBST(mockBSTTreeRoot));
    }

}

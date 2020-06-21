package kata.treeandgraph.firstcommonancestor;

import kata.treeandgraph.MockTreeFactory;
import kata.treeandgraph.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class FirstCommonAncestorWithLinksToParentsTest {

    @Test
    public void firstCommonAncestorTest() {
        FirstCommonAncestorWithLinksToParents firstCommonAncestor = new FirstCommonAncestorWithLinksToParents();

        TreeNode mockNotBSTTreeRoot = MockTreeFactory.getMockNotBSTTreeRoot();

        TreeNode node1 = mockNotBSTTreeRoot.left.left;
        TreeNode node2 = mockNotBSTTreeRoot.right;

        TreeNode actual = firstCommonAncestor.commonAncestor(node1, node2);

        Assert.assertEquals(mockNotBSTTreeRoot, actual);
    }
}
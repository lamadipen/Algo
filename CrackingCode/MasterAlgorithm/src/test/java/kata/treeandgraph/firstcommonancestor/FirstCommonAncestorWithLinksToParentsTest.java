package kata.treeandgraph.firstcommonancestor;

import kata.treeandgraph.MockTreeFactory;
import kata.treeandgraph.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class FirstCommonAncestorWithLinksToParentsTest {

    @Test
    public void firstCommonAncestorTestWithLinkToParents() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();

        TreeNode mockNotBSTTreeRoot = MockTreeFactory.getMockNotBSTTreeRootWithLinkToParents();

        TreeNode node1 = mockNotBSTTreeRoot.left.left;
        TreeNode node2 = mockNotBSTTreeRoot.right;

        TreeNode actual = firstCommonAncestor.commonAncestorWithLinkToParent(node1, node2);

        Assert.assertEquals(mockNotBSTTreeRoot, actual);
    }


    @Test
    public void firstCommonAncestorTestWithoutLinkToParents() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();

        TreeNode mockNotBSTTreeRoot = MockTreeFactory.getMockNotBSTTreeRoot();

        TreeNode node1 = mockNotBSTTreeRoot.left.left;
        TreeNode node2 = mockNotBSTTreeRoot.right;

        TreeNode actual = firstCommonAncestor.commonAncestorWithoutLinkToParent(mockNotBSTTreeRoot, node1, node2);

        Assert.assertEquals(mockNotBSTTreeRoot, actual);
    }

    @Test
    public void firstCommonAncestorTest2WithoutLinkToParents() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();

        TreeNode mockNotBSTTreeRoot = MockTreeFactory.getMockNotBSTTreeRoot();

        TreeNode node1 = mockNotBSTTreeRoot.left.left;
        TreeNode node2 = mockNotBSTTreeRoot.left;

        TreeNode actual = firstCommonAncestor.commonAncestorWithoutLinkToParent(mockNotBSTTreeRoot, node1, node2);

        Assert.assertEquals(node2, actual);
    }

    @Test
    public void commonAncestorWithoutLinkToParentOptimizedTest() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();

        TreeNode mockNotBSTTreeRoot = MockTreeFactory.getMockNotBSTTreeRoot();

        TreeNode node1 = mockNotBSTTreeRoot.left.left;
        TreeNode node2 = mockNotBSTTreeRoot.right;

        TreeNode actual = firstCommonAncestor.commonAncestorWithoutLinkToParentOptimized(mockNotBSTTreeRoot, node1, node2);

        Assert.assertEquals(mockNotBSTTreeRoot, actual);
    }
}
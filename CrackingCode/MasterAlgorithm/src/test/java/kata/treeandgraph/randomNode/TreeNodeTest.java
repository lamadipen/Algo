package kata.treeandgraph.randomNode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {

    @Test
    public void addNodeTest() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.addNodeInorder(5);
        Assert.assertEquals(2, treeNode.size);
        Assert.assertEquals(5, treeNode.left.data);
    }

    @Test
    public void findNodeTest() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.addNodeInorder(5);
        treeNode.addNodeInorder(13);

        TreeNode result = treeNode.find(13);
        Assert.assertEquals(new TreeNode(13), result);

        TreeNode resultNull = treeNode.find(7);
        Assert.assertNull(resultNull);
    }

    @Test
    public void findRandomNode() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.addNodeInorder(5);
        treeNode.addNodeInorder(13);
        treeNode.addNodeInorder(12);
        treeNode.addNodeInorder(1);
        treeNode.addNodeInorder(3);
        treeNode.addNodeInorder(4);

        List<TreeNode> randomNodes = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            randomNodes.add(treeNode.findRandomNode());
        }

        randomNodes.forEach(randomNode -> System.out.println(randomNode.data));
    }

}
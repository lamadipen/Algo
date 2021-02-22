package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class BiNodeSolutionTest {

    @Test
    public void convertToLinkedListTest1() {
        BiNodeSolution biNodeSolution = new BiNodeSolution();
        BiNode root = buildBiNode();

        NodePair nodePair = biNodeSolution.convertToLinkedListWithAdditionalDataStructure(root);
        System.out.println(nodePair.head.value + " tail" + nodePair.tail.value);
        Assert.assertEquals(0, nodePair.head.value);
        Assert.assertEquals(6, nodePair.tail.value);
    }

    @Test
    public void convertToLinkedListTest2() {
        BiNodeSolution biNodeSolution = new BiNodeSolution();
        BiNode root = buildBiNode();

        BiNode biNode = biNodeSolution.convertToLinkedListWithRetrievingTail(root);
        System.out.println(biNode.value + " tail" + biNode.value);
        Assert.assertEquals(0, biNode.value);
        // Assert.assertEquals(6, biNode.value);
    }

    @Test
    public void convertToLinkedListTest3() {
        BiNodeSolution biNodeSolution = new BiNodeSolution();
        BiNode root = buildBiNode();

        BiNode biNode = biNodeSolution.convertToCircular(root);
        System.out.println(biNode.value + " tail" + biNode.value);
        Assert.assertEquals(0, biNode.value);
        // Assert.assertEquals(6, biNode.value);
    }

    private BiNode buildBiNode() {
        BiNode root = new BiNode(4);
        BiNode leftA = new BiNode(2);
        BiNode rightA = new BiNode(5);
        root.left = leftA;
        root.right = rightA;
        BiNode leftB = new BiNode(1);
        BiNode leftC = new BiNode(3);
        leftA.left = leftB;
        leftA.right = leftC;
        BiNode leftD = new BiNode(0);
        leftB.left = leftD;
        BiNode rightB = new BiNode(6);
        rightA.right = rightB;
        return root;
    }
}
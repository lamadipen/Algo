package kata.treeandgraph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ListOfDepthsTest {

    @Test
    public void testListOfDepthsDFS() {
        TreeNode mockTreeRoot = MockTreeFactory.getMockTreeRoot();
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.traverse(mockTreeRoot);

        ListOfDepths listOfDepths = new ListOfDepths();
        List<LinkedList<TreeNode>> levelDFS = listOfDepths.createLevelDFS(mockTreeRoot);

        System.out.println("####  ####");
        for (LinkedList<TreeNode> item : levelDFS) {
            for (TreeNode node : item) {
                System.out.print(node.data + " -> ");
            }
            System.out.println("Level change");
        }
    }

    @Test
    public void testListOfDepthsBFS() {
        TreeNode mockTreeRoot = MockTreeFactory.getMockTreeRoot();
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.traverse(mockTreeRoot);

        ListOfDepths listOfDepths = new ListOfDepths();
        List<LinkedList<TreeNode>> levelDFS = listOfDepths.createLevelBFS(mockTreeRoot);

        System.out.println("####  ####");
        for (LinkedList<TreeNode> item : levelDFS) {
            for (TreeNode node : item) {
                System.out.print(node.data + " -> ");
            }
            System.out.println("Level change");
        }
    }

}
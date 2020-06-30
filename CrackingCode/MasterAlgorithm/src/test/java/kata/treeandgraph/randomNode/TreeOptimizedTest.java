package kata.treeandgraph.randomNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeOptimizedTest {

    @Test
    public void findRandomNode() {
        TreeOptimized treeOptimized = new TreeOptimized();
        treeOptimized.insertInOrder(5);
        treeOptimized.insertInOrder(13);
        treeOptimized.insertInOrder(12);
        treeOptimized.insertInOrder(1);
        treeOptimized.insertInOrder(3);
        treeOptimized.insertInOrder(4);
        List<TreeNode> randomNodes = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            randomNodes.add(treeOptimized.findRandomNode());
        }
        randomNodes.forEach(randomNode -> System.out.println(randomNode != null ? randomNode.data : 0));
    }

}
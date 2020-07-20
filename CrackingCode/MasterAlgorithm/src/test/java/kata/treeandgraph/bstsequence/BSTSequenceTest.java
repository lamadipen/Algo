package kata.treeandgraph.bstsequence;

import kata.treeandgraph.MockTreeFactory;
import kata.treeandgraph.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BSTSequenceTest {

    @Test
    public void bstSequence() {
        TreeNode mockBSTTreeRoot = MockTreeFactory.getMockBSTTreeRoot();
        BSTSequence bstSequence = new BSTSequence();
        List<LinkedList<Integer>> actual = bstSequence.allSequence(mockBSTTreeRoot);

        actual.forEach(linkedList -> {
                    System.out.println("--->");
                    linkedList.forEach(item -> System.out.print(item + " "));
                    System.out.println("");
                }
        );
    }

    @Test
    public void bstSequenceWithSmallInput() {
        TreeNode mockBSTTreeRoot = MockTreeFactory.getMockSmallBSTTreeRoot();
        BSTSequence bstSequence = new BSTSequence();
        List<LinkedList<Integer>> actual = bstSequence.allSequence(mockBSTTreeRoot);

        actual.forEach(linkedList -> {
                    System.out.println("--->");
                    linkedList.forEach(item -> System.out.print(item + " "));
                    System.out.println("");
                }
        );
    }
}
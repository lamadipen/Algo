package kata.treeandgraph.bstsequence;


import kata.treeandgraph.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTSequence {

    public List<LinkedList<Integer>> allSequence(TreeNode<Integer> node) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        List<LinkedList<Integer>> leftSeq = allSequence(node.left);
        List<LinkedList<Integer>> rightSeq = allSequence(node.right);

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private void weaveLists(LinkedList<Integer> left, LinkedList<Integer> right, List<LinkedList<Integer>> weaved, LinkedList<Integer> prefix) {
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(left);
            result.addAll(right);
            weaved.add(result);
            return;
        }

        Integer headLeft = left.removeFirst();
        prefix.addLast(headLeft);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        left.addFirst(headLeft);

        Integer headRight = right.removeFirst();
        prefix.addLast(headRight);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        right.addFirst(headLeft);
    }
}

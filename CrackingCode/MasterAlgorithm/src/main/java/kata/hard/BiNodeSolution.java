package kata.hard;

import java.util.Objects;

/**
 * Hard
 * BiNode
 * CC: pg 188 Q: 17.12
 */
public class BiNodeSolution {


    /**
     * Runtime O(N) where n is number of nodes
     *
     * @param root
     * @return
     */
    public NodePair convertToLinkedListWithAdditionalDataStructure(BiNode root) {
        if (root == null) {
            return null;
        }
        NodePair left = convertToLinkedListWithAdditionalDataStructure(root.left);
        NodePair right = convertToLinkedListWithAdditionalDataStructure(root.right);

        if (left != null) {
            concat(left.tail, root);
        }

        if (right != null) {
            concat(root, right.head);
        }
        return new NodePair(
                left == null ? root : left.head,
                right == null ? root : right.tail
        );
    }

    private void concat(BiNode x, BiNode y) {
        x.left = y;
        y.right = x;
    }

    /**
     * Runtime O(N^2) where n is number of nodes
     * as getTail will touch all the nodes again
     *
     * @param root
     * @return
     */
    public BiNode convertToLinkedListWithRetrievingTail(BiNode root) {
        if (root == null) {
            return null;
        }
        BiNode left = convertToLinkedListWithRetrievingTail(root.left);
        BiNode right = convertToLinkedListWithRetrievingTail(root.right);

        if (left != null) {
            concat(getTail(left), root);
        }

        if (right != null) {
            concat(root, right);
        }
        return left == null ? root : left;
    }

    private BiNode getTail(BiNode node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public BiNode convertToCircular(BiNode root) {
        if (root == null) return null;

        BiNode part1 = convertToCircular(root.left);
        BiNode part3 = convertToCircular(root.right);

        if (part1 == null & part3 == null) {
            root.left = root;
            root.right = root;
            return root;
        }

        BiNode tail3 = (part3 == null) ? null : part3.left;

        if (part1 == null) {
            concat(part3.left, root);
        } else {
            concat(part1.left, root);
        }

        if (part3 == null) {
            concat(root, part1);
        } else {
            concat(root, part3);
        }

        if (part1 != null && part3 != null) {
            concat(tail3, part1);
        }
        return part1 == null ? root : part1;
    }
}


class BiNode {
    BiNode left, right;
    int value;

    public BiNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiNode biNode = (BiNode) o;
        return value == biNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

class NodePair {
    BiNode head, tail;

    public NodePair(BiNode head, BiNode tail) {
        this.head = head;
        this.tail = tail;
    }


}
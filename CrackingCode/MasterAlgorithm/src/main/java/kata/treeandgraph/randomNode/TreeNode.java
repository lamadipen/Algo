package kata.treeandgraph.randomNode;

import java.util.Objects;
import java.util.Random;

/**
 * Random Node
 * CC: pg 111 Q: 4.11
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int size;

    public TreeNode(int input) {
        this.data = input;
        size = 1;
    }

    public void addNodeInorder(int input) {
        if (input <= data) {
            if (null == left) {
                left = new TreeNode(input);
            } else {
                left.addNodeInorder(input);
            }
        } else {
            if (null == right) {
                right = new TreeNode(input);
            } else {
                right.addNodeInorder(input);
            }
        }
        size++;
    }

    public TreeNode find(int input) {
        if (data == input) return this;
        if (input <= data) {
            return left != null ? left.find(input) : null;
        } else if (input > data) {
            return right != null ? right.find(input) : null;
        } else {
            return null;
        }
    }

    public TreeNode findRandomNode() {
        int leftSize = left != null ? left.size : 0;
        Random random = new Random();
        int index = random.nextInt(size);

        if (index < leftSize) {
            return left.findRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.findRandomNode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return data == treeNode.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public TreeNode findByIndex(int index) {
        int leftSize = left == null ? 0 : left.size;
        if (index < leftSize) {
            return left.findByIndex(index);
        } else if (index == leftSize) {
            return this;
        } else {
            return right.findByIndex(index - (leftSize + 1));
        }
    }
}

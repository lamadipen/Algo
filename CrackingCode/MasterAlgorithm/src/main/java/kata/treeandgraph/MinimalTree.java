package kata.treeandgraph;
/** CC 4.2 page 109
 * Given a sorted increasing order array with unique integer elements.
 * Write an algorithm to create a binary search tree with minimal height.
 * */
public class MinimalTree {
    public TreeNode create(int[] input) {
        return create(input, 0, input.length - 1);
    }

    private TreeNode create(int[] input, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;

        TreeNode current = new TreeNode(input[mid]);
        current.left = create(input, start, mid);
        current.right = create(input, mid + 1, end);
        return current;
    }


}

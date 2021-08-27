package hackerrank.interviewprepkit.recursionandbacktracking;

/**
 * Interview Preparation Kit | Trees | Binary Search Tree : Lowest Common Ancestor
 */
public class BinarySearchTreeLowestCommonAncestor {


    public static Node lca(Node root, int v1, int v2) {
        if (v1 < root.data && v2 > root.data) {
            return root;
        }
        if (v1 > root.data && v2 < root.data) {
            return root;
        }
        if (root.data == v1 || root.data == v2) {
            return root;
        }
        if (root.left.data == v1 || root.right.data == v1 || root.left.data == v2 || root.right.data == v2) {
            return root;
        }
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }
        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        return root;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    /**
     * Runtime: O(log n) on a balanced tree
     * Space Complexity: O(1)
     * <p>
     * Solution is based on the following thought: The value of a common ancestor has to always be between the two values in question.
     */
    static Node lcaHk(Node root, int v1, int v2) {
        //Decide if you have to call rekursively
        //Samller than both
        if (root.data < v1 && root.data < v2) {
            return lcaHk(root.right, v1, v2);
        }
        //Bigger than both
        if (root.data > v1 && root.data > v2) {
            return lcaHk(root.left, v1, v2);
        }

        //Else solution already found
        return root;
    }

}


class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

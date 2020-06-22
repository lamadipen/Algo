package kata.treeandgraph;

public class MockTreeFactory {
    public static TreeNode getMockTreeRoot() {
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(7);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(6);
        TreeNode<Integer> node6 = new TreeNode<>(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        return root;
    }

    public static TreeNode getMockBSTTreeRoot() {
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(7);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(6);
        TreeNode<Integer> node6 = new TreeNode<>(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        return root;
    }

    public static TreeNode getMockNotBSTTreeRoot() {
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(7);
        TreeNode<Integer> node3 = new TreeNode<>(8);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(6);
        TreeNode<Integer> node6 = new TreeNode<>(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        return root;
    }

    public static TreeNode getMockNotBSTTreeRootWithLinkToParents() {
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(7);
        TreeNode<Integer> node3 = new TreeNode<>(8);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(6);
        TreeNode<Integer> node6 = new TreeNode<>(9);

        root.left = node1;
        root.right = node2;
        node1.parent = root;
        node1.left = node3;
        node1.right = node4;
        node2.parent = root;
        node2.left = node5;
        node2.right = node6;

        node3.parent = node1;
        node4.parent = node1;
        node5.parent = node2;
        node6.parent = node2;

        return root;
    }

    public static TreeNode getMockWithSuccessorTreeRoot() {
        //After inorder traversal
        //[1,2,3,4,7,8,9]
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(8);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(3);
        TreeNode<Integer> node5 = new TreeNode<>(7);
        TreeNode<Integer> node6 = new TreeNode<>(9);

        root.left = node1;
        root.right = node2;
        node1.parent = root;
        node2.parent = root;

        node1.left = node3;
        node1.right = node4;
        node3.parent = node1;
        node4.parent = node1;

        node2.left = node5;
        node2.right = node6;
        node5.parent = node2;
        node6.parent = node2;

        return root;
    }
}

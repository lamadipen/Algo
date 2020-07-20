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

    public static TreeNode getMockSmallBSTTreeRoot() {
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(7);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

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


    public static TreeNode getMockForPathWithSumTreeRoot() {
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> nodeMinus3 = new TreeNode<>(-3);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node11 = new TreeNode<>(11);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node3Second = new TreeNode<>(3);
        TreeNode<Integer> nodeMinus2Second = new TreeNode<>(9);

        root.left = node5;
        root.right = nodeMinus3;
        node5.left = node3;
        node5.right = node2;
        nodeMinus3.right = node11;
        node2.right = node1;
        node3.left = node3Second;
        node3.right = nodeMinus2Second;

        return root;
    }
}

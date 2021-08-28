package hackerrank.interviewprepkit.trees;

import org.junit.Assert;
import org.junit.Test;


public class BinarySearchTreeLowestCommonAncestorTest {

    @Test
    public void lcaTest1() {
        int inputSize = 6;
        int inputs[] = {4, 2, 3, 1, 7, 6};


        Node root = null;
        for (int i = 0; i < inputSize; i++) {
            root = BinarySearchTreeLowestCommonAncestor.insert(root, inputs[i]);
        }
        int v1 = 1;
        int v2 = 7;

        Node ans = BinarySearchTreeLowestCommonAncestor.lca(root, v1, v2);
        System.out.println(ans.data);
        Assert.assertEquals(4, ans.data);
    }


    @Test
    public void lcaTest2() {
        int inputSize = 6;
        int inputs[] = {4, 2, 3, 1, 7, 6};


        Node root = null;
        for (int i = 0; i < inputSize; i++) {
            root = BinarySearchTreeLowestCommonAncestor.insert(root, inputs[i]);
        }
        int v1 = 1;
        int v2 = 3;

        Node ans = BinarySearchTreeLowestCommonAncestor.lca(root, v1, v2);
        System.out.println(ans.data);
        Assert.assertEquals(2, ans.data);
    }

    @Test
    public void lcaTest3() {
        int inputSize = 6;
        int inputs[] = {4, 2, 3, 1, 7, 6};


        Node root = null;
        for (int i = 0; i < inputSize; i++) {
            root = BinarySearchTreeLowestCommonAncestor.insert(root, inputs[i]);
        }
        int v1 = 1;
        int v2 = 2;

        Node ans = BinarySearchTreeLowestCommonAncestor.lca(root, v1, v2);
        System.out.println(ans.data);
        Assert.assertEquals(4, ans.data);
    }

    @Test
    public void lcaTest4() {
        int inputSize = 2;
        int inputs[] = {1, 2};

        Node root = null;
        for (int i = 0; i < inputSize; i++) {
            root = BinarySearchTreeLowestCommonAncestor.insert(root, inputs[i]);
        }
        int v1 = 1;
        int v2 = 2;

        Node ans = BinarySearchTreeLowestCommonAncestor.lca(root, v1, v2);
        System.out.println(ans.data);
        Assert.assertEquals(1, ans.data);
    }
}
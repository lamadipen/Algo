package com.dp.hrank.java;

import java.util.ArrayList;
import java.util.*;

import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        //implement this
        return (int)result;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor().equals(Color.RED)) {
            result = (result * node.getValue())% M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor().equals(Color.RED)) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeavesSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        //implement this
        return Math.abs(evenDepthNonLeavesSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node)
    {
        //implement this
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeavesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor().equals(Color.GREEN)) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

 class Solution {

    private static int[] nodeValues;
    private static Color[] nodeColors;
    private static Map<Integer, Set<Integer>> adjecentList = new HashMap();

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        nodeValues = new int[numberOfNodes];
        nodeColors = new Color[numberOfNodes];


        for(int i = 0; i < numberOfNodes; i++){
            nodeValues[i] = sc.nextInt();
        }

        for(int i = 0; i < numberOfNodes; i ++){
            nodeColors[i] = sc.nextInt() == 0? Color.RED : Color.GREEN;
        }

        TreeNode root;
        if(numberOfNodes == 1){
            root = new TreeNode(nodeValues[0], nodeColors[0], 0);
        }else{
            //number if edges is always less than number of nodes
            for(int i = 0; i < numberOfNodes - 1; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();

                Set<Integer> uEdges = adjecentList.get(u);

                if (uEdges == null) {
                    uEdges = new HashSet<>();
                }

                uEdges.add(v);
                adjecentList.put(u,uEdges);

                Set<Integer> vEdges = adjecentList.get(v);
                if (vEdges == null) {
                    vEdges = new HashSet<>();
                }
                vEdges.add(u);
                adjecentList.put(v, vEdges);
            }

            root = new TreeNode(nodeValues[0], nodeColors[0], 0);
            Set<Integer> rootEdges = adjecentList.get(1);

            Iterator<Integer> rootIterator = rootEdges.iterator();

            while (rootIterator.hasNext()) {
                Integer nodeIdentifier = rootIterator.next();
                adjecentList.get(nodeIdentifier).remove(1);
                creteEdge(root, nodeIdentifier);
            }

        }

        return root;
    }

     public static void creteEdge(Tree parentNode, Integer nodeIdentifier) {

        Set<Integer> nodeEdges = adjecentList.get(nodeIdentifier);

        boolean hasChild = false;

        if(nodeEdges != null && !nodeEdges.isEmpty())
            hasChild = true;


        if(hasChild){
            TreeNode node = new TreeNode(nodeValues[nodeIdentifier -1],
                    nodeColors[nodeIdentifier -1],
                    parentNode.getDepth()+1);
            ((TreeNode)parentNode).addChild(node);
            Iterator<Integer> nodeIterator = nodeEdges.iterator();
            while (nodeIterator.hasNext()){
                Integer neighborNodeIdentifier = nodeIterator.next();
                adjecentList.get(neighborNodeIdentifier).remove(nodeIdentifier);
                creteEdge(node, neighborNodeIdentifier);
            }
        } else{
            TreeLeaf leaf = new TreeLeaf(nodeValues[nodeIdentifier -1],
                    nodeColors[nodeIdentifier -1],
                    parentNode.getDepth() +1);
            ((TreeNode)parentNode).addChild(leaf);
        }
     }


    public static void main(String[] args) {
//        System.out.print(Color.);;
//        System.exit(1);
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

/*
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
*/
package kata.treeandgraph;

/** Min Heap is a complete binary tree where all levels are
 * filled other than the rightest most part of the last level.*/
public class MinHeapWithArray {
    int size;
    int[] nodes;
    int index = 1;
    int startPosition = 1;

    public MinHeapWithArray(int size) {
        this.size = size;
        nodes = new int[size*2];
    }

    public void insertElement(int data) {
        nodes[index++] = data;
        percolateDown(this.index - startPosition);
    }

    private void percolateDown(int lastNodeIndex) {
        if(lastNodeIndex == 1) return;
        int parentNodeIndex = getParentNodeIndex(lastNodeIndex);
        if (nodes[parentNodeIndex] > nodes[lastNodeIndex]) {
            int tempValue = nodes[parentNodeIndex];
            nodes[parentNodeIndex] = nodes[lastNodeIndex];
            nodes[lastNodeIndex] = tempValue;
            percolateDown(parentNodeIndex);
        }
    }

    private int getParentNodeIndex(int lastNodeIndex) {
        return lastNodeIndex / 2;
    }

    public int peekMinElement() {
      return nodes[startPosition];
    }

    public int removeMinElement() {
        int actualIndex = index - 1;
        int lastNode = nodes[actualIndex];
        int minNode = nodes[startPosition];
        nodes[startPosition] = lastNode;
        nodes[actualIndex] = 0;
        percolateUp(startPosition);
        return minNode;
    }

    private void percolateUp(int initialNode) {
        int childNodeIndex = getChildNode(initialNode);
        if (nodes[initialNode] > nodes[childNodeIndex]) {
            int tempValue = nodes[childNodeIndex];
            nodes[childNodeIndex] = nodes[initialNode];
            nodes[initialNode] = tempValue;
            percolateDown(childNodeIndex);
        }
    }

    private int getChildNode(int initialNode) {
        int leftNodeIndex = getLeftChiIdIndex(initialNode);
        int rightNodeIndex = getRightChildIndex(initialNode);

        if (nodes[leftNodeIndex] > nodes[rightNodeIndex]) {
            return rightNodeIndex;
        }else{
            return leftNodeIndex;
        }
    }

    private int getRightChildIndex(int initialNode) {
        return initialNode * 2 + 1;
    }

    private int getLeftChiIdIndex(int initialNode) {
        return initialNode * 2;
    }
}

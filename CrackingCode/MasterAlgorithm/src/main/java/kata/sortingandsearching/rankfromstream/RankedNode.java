package kata.sortingandsearching.rankfromstream;

/**
 * Check Sorting and Searching:
 * Rank from Stream
 * CC: pg 151 Q: 10.10
 * <p>
 * Runtime O(logn) => number of elements if tree is balanced
 * O(n) => unbalanced tree
 */
public class RankedNode {
    int data;
    int leftCount = 0;
    RankedNode left, right;

    public RankedNode(int data) {
        this.data = data;
    }

    public void insert(int d) {
        if (d <= this.data) {
            if (left == null) {
                left = new RankedNode(d);
            } else {
                left.insert(d);
            }
            leftCount++;
        } else {
            if (right == null) {
                right = new RankedNode(d);
            } else {
                right.insert(d);
            }
        }
    }

    public int getRank(int d) {
        if (d == data) {
            return leftCount;
        } else if (d < data) {
            if (left == null) {
                return -1;
            } else {
                return left.getRank(d);
            }
        } else {
            int rightCount = right == null ? -1 : right.getRank(d);

            if (rightCount == -1) {
                return -1;
            } else {
                return rightCount + 1 + leftCount;
            }
        }
    }
}

package kata.sortingandsearching.rankfromstream;

public class RankFromStreamSolution {
    RankedNode root = null;

    public void track(int d) {
        if (root == null) {
            root = new RankedNode(d);
        } else {
            if (d <= root.data) {
                root.insert(d);
            } else {
                root.insert(d);
            }
        }
    }

    public int getRank(int d) {
        return root.getRank(d);
    }
}

package hackerrank.interviewprepkit.trees;

/**
 * Interview Preparation Kit | Trees | Tree : Huffman Decoding
 */
public class HuffmanDecoding {
    /**
     * Runtime O(n)
     * Space Complexity => if stringbuilder is used then O(n)
     * Space Complexity => if stringbuilde is not used O(1)
     *
     * @param s
     * @param root
     */
    void decode(String s, HNode root) {
        StringBuilder sb = new StringBuilder();
        HNode tempRoot = root;

        for (int j = 0; j < s.length(); j++) {
            tempRoot = s.charAt(j) == '1' ? tempRoot.right : tempRoot.left;

            if (tempRoot.left == null && tempRoot.right == null) {
                sb.append(tempRoot.data);
                //use this line to reduce the time complexity
                //System.out.println("tempRoot = " + tempRoot.data);
                tempRoot = root;
            }
        }
        System.out.println("sb = " + sb);
    }
}

abstract class HNode implements Comparable<HNode> {
    public int frequency; // the frequency of this tree
    public char data;
    public HNode left, right;

    public HNode(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(HNode tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends HNode {
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends HNode {
    public HuffmanNode(HNode l, HNode r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

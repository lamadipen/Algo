package hackerrank.interviewprepkit.miscellaneous;

import java.util.Arrays;

public class MaximumXorSolution {

    /**
     * Runtime O(n*m) where n is number of array times and m is number of queries
     *
     * @param arr
     * @param queries
     * @return
     */
    public static int[] maxXor(int[] arr, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int xorValue = arr[j] ^ queries[i];
                result[i] = Math.max(result[i], xorValue);
            }
        }
        return result;
    }


    /**
     * @param arr
     * @param queries
     * @return
     */
    public static int[] maxXorOptimized(int[] arr, int[] queries) {
        int[] result = new int[queries.length];

        Bit mbs = new Bit();

        for (int a : arr) {
            Bit bit = mbs;
            for (int s = 31; s >= 0; s--) {
                int b = (a >> s) & 1;
                if (bit.bits[b] == null) {
                    bit.bits[b] = new Bit();
                }
                bit = bit.bits[b];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int a = 0;
            Bit bit = mbs;

            for (int s = 31; s >= 0; s--) {
                int b = (queries[i] >> s) & 1;
                if (bit.bits[1 - b] != null) {
                    b = 1 - b;
                }
                a = (a << 1) | b;
                bit = bit.bits[b];
            }
            result[i] = a ^ queries[i];
        }
        return result;
    }

    static class Bit {
        final Bit[] bits = new Bit[2];
    }

    static class TrieNode {
        int value;
        TrieNode[] arr = new TrieNode[2];

        public TrieNode() {
            this.value = 0;
            this.arr[0] = null;
            this.arr[1] = null;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "value=" + value +
                    ", arr=" + Arrays.toString(arr) +
                    '}';
        }
    }

    static TrieNode root;
    static final int INT_SIZE = 32;

    static void insert(int pre_xor) {
        TrieNode temp = root;

        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;

            if (temp.arr[val] == null) {
                temp = new TrieNode();
            }
            temp = temp.arr[val];
        }
        temp.value = pre_xor;
    }


    /**
     * @param arr
     * @param queries
     * @return
     */
    public static int[] maxXorOptimizedWithTries(int[] arr, int[] queries) {
        int[] result = new int[queries.length];

        root = new TrieNode();
        insert(0);
        int pre_xor = 0;
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            pre_xor = ~queries[i];
            result[i] = query(pre_xor);
        }
        return result;
    }

    private static int query(int pre_xor) {
        TrieNode temp = root;

        for (int i = INT_SIZE; i >= 0; i--) {
            int value = (pre_xor & (1 << i)) >= 1 ? 1 : 0;

            if (temp.arr[value] != null) {
                temp = temp.arr[value];
            } else if (temp.arr[1 - value] != null) {
                temp = temp.arr[1 - value];
            }
        }
        return (~pre_xor) ^ (temp.value);
    }

}


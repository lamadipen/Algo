package kata.sortingandsearching;

/**
 * Check Sorting and Searching:
 * Sparse Search
 * CC: pg 150 Q: 10.5
 */
public class SparseSearch {
    public int search(String[] words, String target) {
        if (words == null || target == null || target.isEmpty()) {
            return -1;
        }
        return search(words, 0, words.length - 1, target);
    }

    private int search(String[] words, int start, int end, String target) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (words[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while (true) {
                    if (left > start && !words[left].isEmpty()) {
                        mid = left;
                        break;
                    } else if (right < end && !words[right].isEmpty()) {
                        mid = right;
                        break;
                    } else if (left < start && right > end) {
                        return -1;
                    }
                    left--;
                    right++;
                }
            }

            String midValue = words[mid];

            if (midValue.equals(target)) {
                return mid;
            } else if (midValue.compareTo(target) < 0) {
                start = mid + 1;
            } else if (midValue.compareTo(target) > 0) {
                end = mid - 1;
            }
        }
        return -1;
    }
}

package kata.sortingandsearching;


/**
 * Check Sorting and Searching:
 * CC: pg 141 Q: 10.1
 */
public class SortMerge {
    public void sortMerger(int[] a, int[] b) {
        int aEndIndex = a.length - 1;
        int bIndex = b.length - 1;
        int aIndex = (a.length - b.length) - 1;

        while (bIndex >= 0) {
            if (aIndex >= 0 && a[aIndex] > b[bIndex]) {
                a[aEndIndex] = a[aIndex];
                aIndex--;
            } else {
                a[aEndIndex] = b[bIndex];
                bIndex--;
            }
            aEndIndex--;
        }
    }

}

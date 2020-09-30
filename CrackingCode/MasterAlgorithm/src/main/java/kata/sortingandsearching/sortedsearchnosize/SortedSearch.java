package kata.sortingandsearching.sortedsearchnosize;

public class SortedSearch {

    public int search(Listy list, int target) {
        int index = 1;

        while (list.elementAt(index) != -1 && list.elementAt(index) < target) {
            index *= 2;
        }

        return binarySearch(list, index / 2, index, target);
    }

    private int binarySearch(Listy list, int startIndex, int endIndex, int target) {
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            int middleValue = list.elementAt(mid);
            if (middleValue > target || middleValue == -1) {
                endIndex = mid - 1;
            } else if (middleValue < target) {
                startIndex = mid + 1;
            } else if (middleValue == target) {
                return mid;
            }
        }
        return -1;
    }
}

package kata.sortingandsearching;

/**
 * Check Sorting and Searching:
 * CC: pg 150 Q: 10.3
 * Run time log(n) if contains unique element
 * O(n) if the array contains duplicates
 */
public class SearchInRotatedArray {
    public int find(int[] arr, int target) {
        return find(arr, 0, arr.length - 1, target);
    }

    private int find(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[left] < arr[mid]) {
            if (arr[left] <= target && arr[mid] > target) {
                return find(arr, left, mid - 1, target);
            } else {
                return find(arr, mid + 1, right, target);
            }
        } else if (arr[mid] < arr[right]) {
            if (arr[mid] < target && arr[right] >= target) {
                return find(arr, mid + 1, right, target);
            } else {
                return find(arr, left, mid - 1, target);
            }
        } else if (arr[mid] == arr[left]) {
            if (arr[mid] != arr[right]) {
                return find(arr, mid + 1, right, target);
            } else {
                int result = find(arr, left, mid - 1, target);

                if (result == -1) {
                    return find(arr, mid + 1, right, target);
                } else {
                    return result;
                }
            }
        }


        return -1;
    }
}

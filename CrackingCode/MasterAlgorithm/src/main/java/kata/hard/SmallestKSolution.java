package kata.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Hard
 * Smallest K
 * CC: pg 188 Q: 17.14
 */
public class SmallestKSolution {

    /**
     * Runtime O(nlogn) are we are sorting the array
     *
     * @param array
     * @param k
     * @return
     */
    int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(array);

        int[] smallest = new int[k];
        for (int i = 0; i < k; i++) {
            smallest[i] = array[i];
        }
        return smallest;
    }

    int[] smallestKMaxHeap(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> heap = getKMaxHeap(array, k);
        return heapToArray(heap);
    }

    private int[] heapToArray(PriorityQueue<Integer> heap) {
        int[] array = new int[heap.size()];
        while (!heap.isEmpty()) {
            array[heap.size() - 1] = heap.poll();
        }
        return array;
    }

    private PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new MaxHeapComparator());
        for (int a : array) {
            if (heap.size() < k) {
                heap.add(a);
            } else if (a < heap.peek()) {
                heap.poll();
                heap.add(a);
            }
        }
        return heap;
    }

    public int[] smallestKSelectionRank(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }
        int threshold = rank(array, k - 1);
        int[] smallest = new int[k];
        int count = 0;
        for (int value : array) {
            if (value < threshold) {
                smallest[count] = value;
                count++;
            }
        }
        return smallest;
    }

    private int rank(int[] array, int rank) {
        return rank(array, 0, array.length - 1, rank);
    }

    private int rank(int[] array, int left, int right, int rank) {
        int pivot = array[randomIntRange(left, right)];
        int leftEnd = partition(array, left, right, pivot);
        int leftSize = leftEnd - leftEnd + 1;
        if (rank == leftSize - 1) {
            return max(array, left, leftEnd);
        } else if (rank < leftSize) {
            return rank(array, left, leftEnd, rank);
        } else {
            return rank(array, leftEnd + 1, right, rank - leftSize);
        }
    }

    private int max(int[] array, int left, int right) {
        int max = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    private int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            if (array[left] > pivot) {
                swap(array, left, right);
                right--;
            } else if (array[right] <= pivot) {
                swap(array, left, right);
                left++;
            } else {
                left++;
                right--;
            }
        }

        return left - 1;
    }

    private void swap(int[] array, int left, int right) {
        int t = array[left];
        array[left] = array[right];
        array[right] = t;
    }

    private int randomIntRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
}

class MaxHeapComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
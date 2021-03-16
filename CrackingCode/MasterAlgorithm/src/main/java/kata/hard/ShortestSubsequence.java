package kata.hard;

import java.util.*;

public class ShortestSubsequence {

    /**
     * Runtime O(SB^2)
     * where S is length of small array
     * and B is lenght of big array
     *
     * @param big
     * @param small
     * @return
     */
    public Range shortestSuperSequence(int[] big, int[] small) {
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < big.length; i++) {
            int end = findClosure(big, small, i);
            if (end == -1) {
                break;
            }
            if (bestStart == -1 || end - i < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = end;
            }
        }

        return new Range(bestStart, bestEnd);
    }

    private int findClosure(int[] big, int[] small, int index) {
        int max = -1;
        for (int i = 0; i < small.length; i++) {
            int next = findNext(big, small[i], index);
            if (next == -1) {
                return -1;
            }
            max = Math.max(max, next);
        }
        return max;
    }

    private int findNext(int[] big, int element, int index) {
        for (int i = index; i < big.length; i++) {
            if (big[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Runtime O(SB) & spcae complexity O(SB)
     * where S is length of small array
     * and B is length of big array
     *
     * @param big
     * @param small
     * @return
     */
    public Range shortestSuperSequenceOptimized(int[] big, int[] small) {
        int[][] nextOccurances = getNextOccurences(big, small);
        int[] closures = getClosurest(nextOccurances);
        return getShotestSequence(closures);
    }

    private Range getShotestSequence(int[] closures) {
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < closures.length; i++) {
            if (closures[i] == -1) {
                break;
            }
            int distance = closures[i] - i;

            if (bestStart == -1 || distance < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = closures[i];
            }
        }
        return new Range(bestStart, bestEnd);
    }

    private int[] getClosurest(int[][] nextOccurances) {
        int[] closures = new int[nextOccurances[0].length];

        for (int i = 0; i < nextOccurances[0].length; i++) {
            closures[i] = getMaxClosureAtIndex(nextOccurances, i);
        }
        return closures;
    }

    private int getMaxClosureAtIndex(int[][] nextOccurances, int index) {
        int max = -1;
        for (int i = 0; i < nextOccurances.length; i++) {
            if (nextOccurances[i][index] == -1) {
                return -1;
            }
            max = Math.max(max, nextOccurances[i][index]);
        }
        return max;
    }

    private int[][] getNextOccurences(int[] big, int[] small) {
        int[][] nexts = new int[small.length][big.length];

        for (int i = 0; i < small.length; i++) {
            nexts[i] = getNextOccurence(big, small[i]);
        }
        return nexts;
    }

    private int[] getNextOccurence(int[] big, int value) {
        int[] occurances = new int[big.length];
        int index = -1;
        for (int i = big.length - 1; i >= 0; i--) {
            if (big[i] == value) {
                index = i;
            }
            occurances[i] = index;
        }
        return occurances;
    }

    /**
     * Runtime O(SB) & spcae complexity O(B)
     * where S is length of small array
     * and B is length of big array
     *
     * @param big
     * @param small
     * @return
     */
    public Range shortestSuperSequenceSpaceOptimized(int[] big, int[] small) {
        int[] closures = getClosurest(big, small);
        return getShotestSequence(closures);
    }

    private int[] getClosurest(int[] big, int[] small) {
        int[] closures = new int[big.length];
        for (int i = 0; i < small.length; i++) {
            sweepClosures(big, closures, small[i]);
        }
        return closures;
    }

    private void sweepClosures(int[] big, int[] closures, int value) {
        int next = -1;
        for (int i = big.length - 1; i >= 0; i--) {
            if (big[i] == value) {
                next = i;
            }
            if ((next == -1 || closures[i] < next) && closures[i] != -1) {
                closures[i] = next;
            }
        }
    }

    /**
     * Runtime O(SB)
     * where S is length of small array
     * and B is length of big array
     *
     * @param big
     * @param small
     * @return
     */
    public Range shortestSuperSequenceClosuerOptimized(int[] big, int[] small) {
        List<Queue<Integer>> locations = getLocations(big, small);
        if (locations == null) {
            return null;
        }
        return getshortestClosure(locations);
    }

    private List<Queue<Integer>> getLocations(int[] big, int[] small) {
        Map<Integer, Queue<Integer>> locationEntries = new HashMap<>();

        for (int s : small) {
            Queue<Integer> queue = new LinkedList<>();
            locationEntries.put(s, queue);
        }

        for (int i = 0; i < big.length; i++) {
            Queue<Integer> queue = locationEntries.get(big[i]);
            if (null != queue) {
                queue.add(i);
            }
        }

        List<Queue<Integer>> locations = new ArrayList<>();
        locations.addAll(locationEntries.values());
        return locations;
    }

    /**
     * Runtime O(BlogS)
     *
     * @param locations
     * @return
     */
    private Range getshortestClosure(List<Queue<Integer>> locations) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(Comparator.comparing(HeapNode::getLocationWithInList));
        int max = Integer.MIN_VALUE;

        for (int index = 0; index < locations.size(); index++) {
            Integer head = locations.get(index).remove();
            minHeap.add(new HeapNode(head, index));
            max = Math.max(head, max);
        }
        int min = minHeap.peek().getLocationWithInList();
        int bestRangeMin = min;
        int bestRangeMax = max;

        while (true) {
            HeapNode n = minHeap.poll();
            Queue<Integer> list = locations.get(n.row);
            min = n.locationWithInList;

            if (max - min < bestRangeMax - bestRangeMin) {
                bestRangeMax = max;
                bestRangeMin = min;
            }

            if (list.size() == 0) {
                break;
            }

            n.locationWithInList = list.remove();
            minHeap.add(n);
            max = Math.max(max, n.locationWithInList);
        }
        return new Range(bestRangeMin, bestRangeMax);
    }

}

class Range {
    int start, end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class HeapNode {
    int locationWithInList;
    int row; //row index in MinHeap

    public HeapNode(int locationWithInList, int row) {
        this.locationWithInList = locationWithInList;
        this.row = row;
    }

    public int getLocationWithInList() {
        return locationWithInList;
    }

    public void setLocationWithInList(int locationWithInList) {
        this.locationWithInList = locationWithInList;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
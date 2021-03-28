package kata.hard;

/**
 * Hard
 * Volume Of Histogram
 * CC: pg 189 Q: 17.21
 */
public class VolumeOfHistogramSolution {


    /**
     * Runtime O(n^2)
     *
     * @param histogram
     * @return
     */
    public int findVolume(int[] histogram) {
        int startIndex = 0;
        int endIndex = histogram.length - 1;
        int maxHeightIndex = findIndexOfMax(histogram, startIndex, endIndex);
        int leftVolume = subGraphVolume(histogram, startIndex, maxHeightIndex, true);
        int rightVolume = subGraphVolume(histogram, maxHeightIndex, endIndex, false);
        return leftVolume + rightVolume;
    }

    private int subGraphVolume(int[] histogram, int startIndex, int endIndex, boolean isLeftSide) {
        if (startIndex >= endIndex) {
            return 0;
        }
        int totalVolume = 0;
        if (isLeftSide) {
            int maxIndex = findIndexOfMax(histogram, startIndex, endIndex - 1);
            totalVolume += calculateBorderedVolume(histogram, maxIndex, endIndex);
            totalVolume += subGraphVolume(histogram, startIndex, maxIndex, isLeftSide);
        } else {
            int maxIndex = findIndexOfMax(histogram, startIndex + 1, endIndex);
            totalVolume += calculateBorderedVolume(histogram, startIndex, maxIndex);
            totalVolume += subGraphVolume(histogram, maxIndex, endIndex, isLeftSide);
        }
        return totalVolume;
    }

    private int calculateBorderedVolume(int[] histogram, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return 0;
        }
        int minBar = Math.min(histogram[startIndex], histogram[endIndex]);
        int volume = 0;
        for (int i = startIndex + 1; i < endIndex; i++) {
            volume += minBar - histogram[i];
        }
        return volume;
    }

    private int findIndexOfMax(int[] histogram, int startIndex, int endIndex) {
        int maxIndex = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (histogram[i] > histogram[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Runtime O(n)
     *
     * @param histogram
     * @return
     */
    public int findVolumeOptimized(int[] histogram) {
        int[] leftMaxes = new int[histogram.length];
        int leftMax = leftMaxes[0];

        for (int i = 0; i < histogram.length; i++) {
            leftMax = Math.max(leftMax, histogram[i]);
            leftMaxes[i] = leftMax;
        }

        int totalVolume = 0;
        int rightMax = histogram[histogram.length - 1];

        for (int i = histogram.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, histogram[i]);
            int secondHighestBar = Math.min(rightMax, leftMaxes[i]);

            if (secondHighestBar > histogram[i]) {
                totalVolume += secondHighestBar - histogram[i];
            }
        }
        return totalVolume;
    }

}

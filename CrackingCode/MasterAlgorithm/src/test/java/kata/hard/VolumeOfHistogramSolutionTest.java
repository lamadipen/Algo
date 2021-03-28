package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class VolumeOfHistogramSolutionTest {

    @Test
    public void findVolumeTest() {
        VolumeOfHistogramSolution histogramSolution = new VolumeOfHistogramSolution();
        int[] histogram = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};

        int volume = histogramSolution.findVolume(histogram);

        Assert.assertEquals(26, volume);
    }

    @Test
    public void findVolumeOptimizedTest() {
        VolumeOfHistogramSolution histogramSolution = new VolumeOfHistogramSolution();
        int[] histogram = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};

        int volume = histogramSolution.findVolumeOptimized(histogram);

        Assert.assertEquals(26, volume);
    }

}
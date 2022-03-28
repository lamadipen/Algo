package hackerrank.interviewprepkit.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PoisonousPlantsSolutionTest {

    @Test
    public void poisonousPlantsSC1Null() {
        int actual = PoisonousPlantsSolution.poisonousPlants(null);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void poisonousPlantsSC1ListSize() {
        int actual = PoisonousPlantsSolution.poisonousPlants(Arrays.asList(6, 5, 8, 4, 7, 10, 9));
        Assert.assertEquals(2, actual);
    }

    @Test
    public void poisonousPlantsSC2ListSize() {
        int actual = PoisonousPlantsSolution.poisonousPlantsSol2(Arrays.asList(6, 5, 8, 4, 7, 10, 9));
        Assert.assertEquals(2, actual);
    }

    @Test
    public void poisonousPlantsSC3ListSize() {
        int actual = PoisonousPlantsSolution.poisonousPlantsSol3(Arrays.asList(6, 5, 8, 4, 7, 10, 9));
        Assert.assertEquals(2, actual);
    }
}

package metaprep.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterSoutionTest {

    @Test
    void getTrappedRainWater() {
        int actual = TrappingRainWaterSoution.getTrappedRainWater(new int[]{7, 4, 0, 9});
        Assertions.assertEquals(10,actual);
    }
}
package metaprep.greedyalgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StockBuyAndSellTest {

    @Test
    void bestDaysToBuyAndSellTest1() {
        int[] result = StockBuyAndSell.bestDaysToBuyAndSell(new int[]{100, 180, 260, 310, 40, 535, 695});
        Assertions.assertEquals(4,result[0]);
        Assertions.assertEquals(6,result[1]);
    }
}
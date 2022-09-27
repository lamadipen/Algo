package metaprep.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameScoringSolutionTest {

    @Test
    void gameScoringTest1() {
        GameScoringSolution.gameScoring(4);
    }

    @Test
    void gameScoringTest2() {
        GameScoringSolution.gameScoringV2(4);
    }
}
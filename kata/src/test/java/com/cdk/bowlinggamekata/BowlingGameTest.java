package com.cdk.bowlinggamekata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void setup() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void canRollDice() {
        Assert.assertEquals(1, bowlingGame.rollDice(1));
        Assert.assertEquals(2, bowlingGame.rollDice(2));
        Assert.assertEquals(3, bowlingGame.rollDice(3));
    }

    @Test
    public void canGetScore() {
        bowlingGame.rollDice(2);
        Assert.assertEquals("Player_1:0 Player_2=0", bowlingGame.getScore());
    }

    @Test
    public void canGetScore2RollWithScoreGreaterThanEqual5() {
        bowlingGame.rollDice(2);
        bowlingGame.rollDice(5);
        Assert.assertEquals("Player_1:2 Player_2=0", bowlingGame.getScore());
    }

    @Test
    public void canGetScore3RollWithScoreGreaterThanEqual5() {
        bowlingGame.rollDice(2);
        bowlingGame.rollDice(5);
        bowlingGame.rollDice(4);
        Assert.assertEquals("Player_1:2 Player_2=0", bowlingGame.getScore());
    }

    @Test
    public void canGetScore4RollWithScoreGreaterThanEqual5() {
        bowlingGame.rollDice(2);
        bowlingGame.rollDice(5);
        bowlingGame.rollDice(4);
        bowlingGame.rollDice(2);
        Assert.assertEquals("Player_1:3 Player_2=0", bowlingGame.getScore());
    }
}
package kata.moderate;

import org.junit.Test;

public class MasterMindTest {

    @Test
    public void getHitAndSudohitTest() {
        MasterMind masterMind = new MasterMind();

        Slot solution = new Slot();
        solution.addSlot(Ball.R);
        solution.addSlot(Ball.G);
        solution.addSlot(Ball.B);
        solution.addSlot(Ball.Y);

        Slot guess = new Slot();
        guess.addSlot(Ball.G);
        guess.addSlot(Ball.G);
        guess.addSlot(Ball.R);
        guess.addSlot(Ball.R);

        masterMind.getHitAndSudohit(solution, guess);

        Slot solution1 = new Slot();
        solution1.addSlot(Ball.R);
        solution1.addSlot(Ball.G);
        solution1.addSlot(Ball.B);
        solution1.addSlot(Ball.Y);

        Slot guess1 = new Slot();
        guess1.addSlot(Ball.G);
        guess1.addSlot(Ball.G);
        guess1.addSlot(Ball.G);
        guess1.addSlot(Ball.R);

        masterMind.getHitAndSudohit(solution1, guess1);
    }
}
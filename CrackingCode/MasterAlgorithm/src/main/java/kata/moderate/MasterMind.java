package kata.moderate;

import java.util.HashMap;
import java.util.Map;

/**
 * Moderate
 * Best Line
 * CC: pg 183 Q: 16.15
 */
public class MasterMind {

    public void getHitAndSudohit(Slot solution, Slot guess) {
        int hitCount = 0;
        int psudoCount = 0;
        Map<Ball, Integer> missMap = new HashMap<>();

        for (int i = 0; i < solution.slots.length; i++) {
            if (solution.slots[i] == guess.slots[i]) {
                hitCount++;
                missMap.computeIfPresent(guess.slots[i], (k, v) -> 0);
            } else {
                Ball ball = solution.slots[i];
                missMap.putIfAbsent(ball, 1);
                missMap.computeIfPresent(ball, (k, v) -> v + 1);
            }
        }

        for (int i = 0; i < guess.slots.length; i++) {
            Ball ball = guess.slots[i];
            if (missMap.containsKey(ball) &&
                    missMap.get(ball) > 0 &&
                    ball != solution.slots[i]) {
                psudoCount++;
                missMap.computeIfPresent(ball, (k, v) -> v - 1);
            }
        }
        System.err.println(hitCount + " " + psudoCount);
    }
}

enum Ball {
    R("RED"),
    G("GREEN"),
    Y("YELLOW"),
    B("BLUE");

    Ball(String description) {
    }
}

class Slot {
    Ball[] slots = new Ball[4];
    int index = 0;

    public void addSlot(Ball ball) {
        slots[index] = ball;
        index++;
    }
}

class Result {
    int hits;
    int psudoHits;

    public Result(int hits, int psudoHits) {
        this.hits = hits;
        this.psudoHits = psudoHits;
    }

    @Override
    public String toString() {
        return "Result{" +
                "hits=" + hits +
                ", psudoHits=" + psudoHits +
                '}';
    }
}
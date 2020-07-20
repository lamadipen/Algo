package kata.recursiondynamicprogramming.towerofhanoi;


import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class TowerTest {

    @Test
    public void towerOfHanoiTest() {
        int n = 3;

        Tower[] towers = new Tower[n];

        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = n; i >= 1; i--) {
            towers[0].disks.push(i);
        }

        System.out.println("Source Tower top");
        System.out.println(towers[0].disks.peek());

        towers[0].moveDisk(3, towers[1], towers[2]);

        Stack<Integer> actual = towers[1].disks;
        Assert.assertFalse(actual.isEmpty());
        Assert.assertTrue(towers[0].disks.isEmpty());
        Assert.assertTrue(towers[2].disks.isEmpty());

        System.out.println("Destination Tower");
        while (!actual.isEmpty()) {
            System.out.println(actual.pop());
        }
    }


}
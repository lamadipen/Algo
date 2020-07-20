package kata.recursiondynamicprogramming.towerofhanoi;

import java.util.Stack;

public class Tower {
    Stack<Integer> disks;
    int index;

    public Tower(int index) {
        this.disks = new Stack<>();
        this.index = index;
    }

    public void addDisk(int disk) {
        if (!disks.isEmpty() && disks.peek() <= disk) {
            System.out.println("cannot be added");
        } else {
            disks.push(disk);
        }
    }

    public void moveDisk(int disk, Tower destination, Tower buffer) {
        if (disk > 0) {
            moveDisk(disk - 1, buffer, destination);
            moveTop(destination);
            buffer.moveDisk(disk - 1, destination, this);
        }
    }

    private void moveTop(Tower destination) {
        Integer disk = disks.pop();
        destination.addDisk(disk);
    }
}

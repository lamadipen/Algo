package kata.recursiondynamicprogramming.stackofboxes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StackBoxesTest {

    @Test
    public void canGetMaxStackBoxes() {
        StackBoxes stackBoxes = new StackBoxes();
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10, 10, 10));
        boxes.add(new Box(5, 10, 6));
        boxes.add(new Box(10, 11, 10));
        boxes.add(new Box(9, 9, 9));
        boxes.add(new Box(11, 10, 10));
        boxes.add(new Box(8, 10, 10));

        int maxHeight = stackBoxes.getMaxStacks(boxes);

        System.err.println(maxHeight);
    }

    @Test
    public void canGetMaxStackBoxesOptimized() {
        StackBoxes stackBoxes = new StackBoxes();
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10, 10, 10));
        boxes.add(new Box(5, 10, 6));
        boxes.add(new Box(10, 11, 10));
        boxes.add(new Box(9, 9, 9));
        boxes.add(new Box(11, 10, 10));
        boxes.add(new Box(8, 10, 10));

        int maxHeight = stackBoxes.getMaxStacksOptimized(boxes);

        System.err.println(maxHeight);
    }

    @Test
    public void canGetMaxStackBoxesSecondWay() {
        StackBoxes stackBoxes = new StackBoxes();
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10, 10, 10));
        boxes.add(new Box(5, 10, 6));
        boxes.add(new Box(10, 11, 10));
        boxes.add(new Box(9, 9, 9));
        boxes.add(new Box(11, 10, 10));
        boxes.add(new Box(8, 10, 10));

        int maxHeight = stackBoxes.getMaxStacksSecondWay(boxes);

        System.err.println(maxHeight);
    }
}
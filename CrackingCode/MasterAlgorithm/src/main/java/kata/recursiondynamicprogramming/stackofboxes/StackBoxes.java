package kata.recursiondynamicprogramming.stackofboxes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Recursion and dynamic programming
 * Stack Of Boxes
 * CC: pg 136 Q: 8.13
 */
public class StackBoxes {

    public int getMaxStacks(List<Box> boxes) {
        Collections.sort(boxes, Comparator.comparing(box -> box.length, (b1, b2) -> b2 - b1));
        boxes.forEach(box -> System.out.println(box.toString()));

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int createStack(List<Box> boxes, int index) {
        Box bottom = boxes.get(index);
        int maxHeight = 0;

        for (int i = index + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeOnTop(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottom.height;

        return maxHeight;
    }


    public int getMaxStacksOptimized(List<Box> boxes) {
        Collections.sort(boxes, Comparator.comparing(box -> box.length, (b1, b2) -> b2 - b1));
        boxes.forEach(box -> System.out.println(box.toString()));
        int[] cache = new int[boxes.size()];

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStackOptimized(boxes, i, cache);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int createStackOptimized(List<Box> boxes, int index, int[] cache) {
        if (index < boxes.size() && cache[index] > 0) {
            return cache[index];
        }
        Box bottom = boxes.get(index);
        int maxHeight = 0;

        for (int i = index + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeOnTop(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottom.height;
        cache[index] = maxHeight;

        return maxHeight;
    }

    public int getMaxStacksSecondWay(List<Box> boxes) {
        Collections.sort(boxes, Comparator.comparing(box -> box.length, (b1, b2) -> b2 - b1));
        boxes.forEach(box -> System.out.println(box.toString()));
        int[] cache = new int[boxes.size()];

        return createStackSecondWay(boxes, null, 0, cache);
    }

    public int createStackSecondWay(List<Box> boxes, Box bottom, int offSet, int[] cache) {
        if (offSet >= boxes.size()) {
            return 0;
        }

        Box newBottom = boxes.get(offSet);
        int heightWithBottom = 0;

        if (bottom == null || newBottom.canBeOnTop(bottom)) {
            if (cache[offSet] == 0) {
                cache[offSet] = createStackSecondWay(boxes, newBottom, offSet + 1, cache);
                cache[offSet] += newBottom.height;
            }
            heightWithBottom = cache[offSet];
        }
        int heightWithoutBottom = createStackSecondWay(boxes, bottom, offSet + 1, cache);

        return Math.max(heightWithBottom, heightWithoutBottom);
    }
}


class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box o1, Box o2) {
        return o2.length - o1.length;
    }
}

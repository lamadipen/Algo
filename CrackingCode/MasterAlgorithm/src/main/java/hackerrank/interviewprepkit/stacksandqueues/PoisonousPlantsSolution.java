package hackerrank.interviewprepkit.stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PoisonousPlantsSolution {

    //6 5 8 4 7 10 9
    public static int poisonousPlants(List<Integer> plants) {
        List<LinkedList> parts = new ArrayList();
        LinkedList lastPart = null;

        for (int i = 0; i < plants.size(); i++) {
            if (i > 0 && plants.get(i) <= plants.get(i - 1)) {
                lastPart.append(plants.get(i));
            } else {
                LinkedList part = new LinkedList();
                part.append(plants.get(i));
                parts.add(part);
                lastPart = part;
            }
        }

        int days = 0;
        while (parts.size() > 1) {
            for (int i = 1; i < parts.size(); i++) {
                parts.get(i).removeFirst();
            }

            List<LinkedList> nextParts = new ArrayList<>();

            for (LinkedList part :
                    parts) {
                if (part.head == null) {
                    continue;
                }
                if (!nextParts.isEmpty() && nextParts.get(nextParts.size() - 1).tail.value >= part.head.value) {
                    nextParts.get(nextParts.size() - 1).append(part);
                } else {
                    nextParts.add(part);
                }
            }
            parts = nextParts;
            days++;
        }

        return days;
    }

    public static int poisonousPlantsSol2(List<Integer> plants) {
        ArrayList<Integer> killer = new ArrayList<>();

        int inputSize = plants.size();
        for (int i = 1; i < inputSize; i++) {
            if (plants.get(i) < plants.get(i + 1)) {
                killer.add(i);
            }
        }

        int day = 0;
        while (!killer.isEmpty()) {
            day++;
            ArrayList<Integer> nk = new ArrayList<>();

            for (int i = killer.size() - 1; i >= 0; --i) {
                int k = killer.get(i);

            }

        }
        return 0;
    }

    ////6 5 8 4 7 10 9
    public static int poisonousPlantsSol3(List<Integer> plants) {
        Stack<Pair> stack = new Stack<>();
        int maxDayCount = 0;
        for (int i = plants.size() - 1; i >= 0; i--) {
            int tempDayCount = 0;
            while (!stack.empty() && plants.get(i) < stack.peek().plant) {
                tempDayCount++;
                Pair pair = stack.pop();
                tempDayCount = Math.max(tempDayCount, pair.dayCount);
            }
            maxDayCount = Math.max(tempDayCount, maxDayCount);
            stack.push(new Pair(plants.get(i), tempDayCount));
        }
        return maxDayCount;
    }

}


class Pair {
    int plant;
    int dayCount; //count of Max dead plant at that point

    public Pair(int plant, int dayCount) {
        this.plant = plant;
        this.dayCount = dayCount;
    }
}

class LinkedList {
    Node head;
    Node tail;

    void append(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    void append(LinkedList list) {
        tail.next = list.head;
        tail = list.tail;
    }

    void removeFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
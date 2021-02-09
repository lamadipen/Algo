package kata.hard;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Hard
 * Circus Tower
 * CC: pg 187 Q: 17.8
 */
public class CircusTower {

    /**
     * Runtime O(2^n)
     *
     * @param people
     * @return
     */
    public List<Person> longestIncreasingSequence(List<Person> people) {
        Collections.sort(people);
        return bestSeqAtIndex(people, new ArrayList<Person>(), 0);
    }

    private List<Person> bestSeqAtIndex(List<Person> people, ArrayList<Person> sequence, int index) {
        if (index >= people.size()) {
            return sequence;
        }
        Person person = people.get(index);
        List<Person> bestWith = null;

        if (canBeAdded(person, sequence)) {
            ArrayList<Person> with = (ArrayList<Person>) sequence.clone();
            with.add(person);
            bestWith = bestSeqAtIndex(people, with, index + 1);
        }
        List<Person> bestWithOut = bestSeqAtIndex(people, sequence, index + 1);
        return max(bestWith, bestWithOut);
    }

    private boolean canBeAdded(Person person, List<Person> sequence) {
        if (sequence == null) {
            return false;
        } else if (sequence.size() == 0) {
            return true;
        }
        Person last = sequence.get(sequence.size() - 1);
        return last.shouldBeTop(person);
    }

    private List<Person> max(List<Person> bestWith, List<Person> bestWithOut) {
        if (bestWith == null) {
            return bestWithOut;
        } else if (bestWithOut == null) {
            return bestWith;
        } else {
            return bestWith.size() > bestWithOut.size() ? bestWith : bestWithOut;
        }
    }

    /**
     * Runtime O(n^2)
     */
    public List<Person> longestIncreasingSequenceOptimized(List<Person> people) {
        Collections.sort(people);
        List<List<Person>> solutions = new ArrayList<>();
        List<Person> bestSeq = null;
        for (int i = 0; i < people.size(); i++) {
            List<Person> bestSeqAt = bestSeqAtIndex(people, solutions, i);
            solutions.add(i, bestSeqAt);
            bestSeq = max(bestSeq, bestSeqAt);
        }
        return bestSeq;
    }

    private List<Person> bestSeqAtIndex(List<Person> people, List<List<Person>> solutions, int index) {
        Person person = people.get(index);
        ArrayList<Person> bestSeq = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            List<Person> solution = solutions.get(i);
            if (canBeAdded(person, solution)) {
                bestSeq = (ArrayList<Person>) max(bestSeq, solution);
            }
        }
        ArrayList<Person> bestSeqClone = (ArrayList<Person>) bestSeq.clone();
        bestSeq.add(person);
        return bestSeq;
    }
}

class Person implements Comparable<Person> {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person other) {
        if (height != other.height) {
            return ((Integer) height).compareTo(other.height);
        } else {
            return ((Integer) weight).compareTo(other.weight);
        }
    }

    public boolean shouldBeTop(Person other) {
        if (height < other.height && weight < other.weight) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return height == person.height && weight == person.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight);
    }
}

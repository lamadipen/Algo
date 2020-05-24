package kata.stackqueue;

import java.util.LinkedList;

public class AnimalShelterWithStringLinkedList {
    LinkedList<String> animalShelter = new LinkedList<>();

    public void queue(String animal) {
        animalShelter.addLast(animal);
    }

    public String dequeue() {
        return animalShelter.removeFirst();
    }

    public String dequeueDog() {
        int index = animalShelter.indexOf("dog");
        return animalShelter.remove(index);
    }

    public String dequeueCat() {
        int index = animalShelter.indexOf("cat");
        return animalShelter.remove(index);
    }

    public int size() {
        return animalShelter.size();
    }
}

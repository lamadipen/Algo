package kata.stackqueue;

import java.util.LinkedList;
import java.util.Objects;

public class AnimalShelterWithCustomObject {
    LinkedList<Animal> dogQueue = new LinkedList<>();
    LinkedList<Animal> catQueue = new LinkedList<>();
    int order =0;

    public void queue(Animal animal) {
        animal.sequence = order;
        order++;
        addToQueue(animal);
    }

    private int getSequence(Animal dog, Animal cat) {
        int sequence = 0;
        if (dog == null) {
            sequence = cat.sequence++;
        } else if (cat == null) {
            sequence = dog.sequence++;
        }else{
            if (dog.sequence > cat.sequence) {
                sequence = dog.sequence++;
            }else{
                sequence = cat.sequence++;
            }
        }
        return sequence;
    }

    private void addToQueue(Animal animal) {
        if (Dog.class.isInstance(animal)) {
            dogQueue.addLast(animal);
        } else {
            catQueue.addLast(animal);
        }
    }

    public Cat dequeueCat() {
        return (Cat) catQueue.removeFirst();
    }

    public Dog dequeueDog() {
        return (Dog) dogQueue.removeFirst();
    }

    public Animal dequeue() {
        if (dogQueue.size() == 0) {
            return dequeueCat();
        } else if (catQueue.size() == 0) {
            return dequeueDog();
        }else{
            Animal dog = dogQueue.peekFirst();
            Animal cat = catQueue.peekFirst();

            if(dog.isOlderThan(cat)){
                return dequeueDog();
            }else {
                return dequeueCat();
            }
        }
    }

    public int size() {
        return dogQueue.size() + catQueue.size();
    }
}

class Animal{
    int sequence;
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public boolean isOlderThan(Animal animal) {
        return this.sequence < animal.sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
       super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

package kata.stackqueue;

import org.junit.Assert;
import org.junit.Test;

public class AnimalShelterWithCustomObjectTest {

    @Test
    public void animalShelterTest() {
        AnimalShelterWithCustomObject animalShelter = new AnimalShelterWithCustomObject();

        animalShelter.queue(new Dog("dog"));
        animalShelter.queue(new Cat("cat"));
        animalShelter.queue(new Dog("dog"));
        animalShelter.queue(new Cat("cat"));
        animalShelter.queue(new Dog("dog"));

        Assert.assertEquals(new Dog("dog"),animalShelter.dequeue());
        Assert.assertEquals(new Cat("cat"),animalShelter.dequeue());
        Assert.assertNotEquals(new Cat("cat"),animalShelter.dequeue());

        animalShelter.queue(new Dog("dog"));
        animalShelter.queue(new Cat("cat"));
        animalShelter.queue(new Dog("dog"));

        Assert.assertEquals(new Dog("dog"), animalShelter.dequeueDog());
        Assert.assertEquals(new Cat("cat"), animalShelter.dequeueCat());
        Assert.assertEquals(3,animalShelter.size());

    }
}

package kata.stackqueue;

import org.junit.Assert;
import org.junit.Test;

public class AnimalShelterWithStringLinkedListTest {

    @Test
    public void animalShelterTest() {
        AnimalShelterWithStringLinkedList animalShelter = new AnimalShelterWithStringLinkedList();

        animalShelter.queue("dog");
        animalShelter.queue("cat");
        animalShelter.queue("dog");
        animalShelter.queue("cat");
        animalShelter.queue("dog");

        Assert.assertEquals("dog",animalShelter.dequeue());
        Assert.assertEquals("cat",animalShelter.dequeue());
        Assert.assertNotEquals("cat",animalShelter.dequeue());

        animalShelter.queue("dog");
        animalShelter.queue("cat");
        animalShelter.queue("dog");

        Assert.assertEquals("dog", animalShelter.dequeueDog());
        Assert.assertEquals("cat", animalShelter.dequeueCat());
        Assert.assertEquals(3,animalShelter.size());

    }
}

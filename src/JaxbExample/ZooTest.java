package JaxbExample;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ZooTest {

    @Test
    public void addAnimals() {

        ArrayList<Animal> expected = Zoo.addAnimals();

        ArrayList<Animal> actual = new ArrayList<>();

        actual.add(new Elephant("Dumbo", 10, 573.6d));
        actual.add(new Giraffe("Melman", 5, 5.5d));
        actual.add(new Dog("Layka", 10));
        actual.add(new Cat("Murka", 5));

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void marshalToXmlString() {
    }

    @Test
    public void addAnimals_Not_Null() {
        Assert.assertNotNull(Zoo.addAnimals());
    }
}
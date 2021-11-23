package JaxbExample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;


@XmlRootElement(name = "zoo")
public class Zoo {


    private ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Zoo zoo = new Zoo(addAnimals());

        System.out.println(zoo.marshalToXmlString());
    }

    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public Zoo(){}

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    @XmlElementWrapper(name = "animals", nillable = true)
    @XmlElements({
            @XmlElement(name = "elephant", type = Elephant.class),
            @XmlElement(name = "giraffe", type = Giraffe.class),
            @XmlElement(name = "dog", type = Dog.class),
            @XmlElement(name = "cat", type = Cat.class)})
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public static ArrayList<Animal> addAnimals() {

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Elephant("Dumbo", 10, 573.6d));
        animals.add(new Giraffe("Melman", 5, 5.5d));
        animals.add(new Dog("Layka", 10));
        animals.add(new Cat("Murka", 5));

        return animals;
    }

    public String marshalToXmlString() {

        try {
            StringWriter writer = new StringWriter();

            JAXBContext context = JAXBContext.newInstance(this.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this, writer);
            return writer.toString();

        } catch (JAXBException jaxbException) {
            jaxbException.printStackTrace();
        }
        return null;
    }

}

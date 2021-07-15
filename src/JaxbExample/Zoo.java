package JaxbExample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;


@XmlRootElement(name = "zoo")
public class Zoo {

    @XmlElementWrapper(name = "animals", nillable = true)
    @XmlElements({
            @XmlElement(name = "elephant", type = Elephant.class),
            @XmlElement(name = "giraffe", type = Giraffe.class),
            @XmlElement(name = "dog", type = Dog.class),
            @XmlElement(name = "cat", type = Cat.class)})
    public ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Zoo zoo = createZoo();

        System.out.println(zoo.marshalToXmlString());
    }

    public static Zoo createZoo() {

        Zoo zoo = new Zoo();
        Elephant elephant1 = new Elephant("Dumbo", 10, 573.6d);
        zoo.animals.add(elephant1);
        Giraffe giraffe1 = new Giraffe("John", 5, 5.5d);
        zoo.animals.add(giraffe1);
        Dog dog1 = new Dog("Layka", 10);
        zoo.animals.add(dog1);
        Cat cat1 = new Cat("Murka", 5);
        zoo.animals.add(cat1);

        return zoo;
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

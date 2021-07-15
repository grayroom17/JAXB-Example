package JaxbExample;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "age"})
public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Animal() {
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }


    @XmlAttribute(name = "age")
    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


}

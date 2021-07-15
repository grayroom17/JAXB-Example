package JaxbExample;

import javax.xml.bind.annotation.XmlElement;

public class Elephant extends Animal {
    private double weight;

    public Elephant(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
    }

    Elephant() {
    }

    public double getWeight() {
        return weight;
    }

    @XmlElement(name = "mass")
    public void setWeight(double weight) {
        this.weight = weight;
    }
}

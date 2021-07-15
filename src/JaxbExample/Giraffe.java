package JaxbExample;

import javax.xml.bind.annotation.XmlElement;

public class Giraffe extends Animal {
    private double height;

    public Giraffe(String name, int age, double height) {
        super(name, age);
        this.height = height;
    }

    Giraffe() {
    }

    public double getHeight() {
        return height;
    }

    @XmlElement(name = "height")
    public void setHeight(double height) {
        this.height = height;
    }
}

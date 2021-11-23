package JaxbExample;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Giraffe extends Animal {
    private double height;

    public Giraffe(String name, int age, double height) {
        super(name, age);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @XmlElement(name = "height")
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giraffe giraffe = (Giraffe) o;
        return (this.getAge() == giraffe.getAge()
                && Objects.equals(this.getName(), giraffe.getName())
                && this.getHeight() == giraffe.getHeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getAge(), this.getHeight());
    }
}

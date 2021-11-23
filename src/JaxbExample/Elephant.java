package JaxbExample;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Elephant extends Animal {
    private double weight;

    public Elephant(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
    }


    public double getWeight() {
        return weight;
    }

    @XmlElement(name = "mass")
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elephant elephant = (Elephant) o;
        return (this.getAge() == elephant.getAge()
                && Objects.equals(this.getName(), elephant.getName())
                && this.getWeight() == elephant.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getAge(), this.getWeight());
    }
}

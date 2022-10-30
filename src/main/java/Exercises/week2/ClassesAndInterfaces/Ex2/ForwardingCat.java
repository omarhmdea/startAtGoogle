package Exercises.week2.ClassesAndInterfaces.Ex2;

public class ForwardingCat{

    private final Cat cat;


    public ForwardingCat(Cat cat) {
        this.cat = cat;
    }

    public String move() {
        return cat.move();
    }

    @Override
    public String toString() {
        return cat.toString();
    }
}

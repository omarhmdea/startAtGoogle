package Exercises.week2.ClassesAndInterfaces.Ex2;

public class WoodenHorse implements WoodenStructures{

    @Override
    public String roll() {
        return "It's rolling";
    }

    @Override
    public WoodenHorse replicate() {
        return new WoodenHorse();
    }
}

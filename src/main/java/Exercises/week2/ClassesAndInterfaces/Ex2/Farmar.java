package Exercises.week2.ClassesAndInterfaces.Ex2;

public class Farmar {

    private final Farm farm;


    public Farmar(Farm farm) {
        this.farm = farm;
    }


    public Farm getFarm() {
        return farm;
    }


    public void move(Animal animal) {
        System.out.println(animal.move());
    }


}

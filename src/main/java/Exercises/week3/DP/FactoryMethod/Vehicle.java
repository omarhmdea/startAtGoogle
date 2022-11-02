package Exercises.week3.DP.FactoryMethod;

public abstract class Vehicle {

    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " traveling with " + this.className());
    }
    public abstract String className();
}

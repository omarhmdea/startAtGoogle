package Exercises.week3.DP.FactoryMethod;

public class Taxi implements Vehicle{

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " traveling with " + this.className());
    }
    @Override
    public String className() {
        return "Taxi";
    }
}

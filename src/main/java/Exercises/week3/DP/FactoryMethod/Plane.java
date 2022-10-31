package Exercises.week3.DP.FactoryMethod;

public class Plane implements Vehicle{

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " traveling with " + this.className());
    }
    @Override
    public String className() {
        return "Plane";
    }
}

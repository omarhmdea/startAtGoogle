package Exercises.week3.DP.FactoryMethod;

import Exercises.week3.DP.FactoryMethod.Passenger;
import Exercises.week3.DP.FactoryMethod.Vehicle;

public class Bus implements Vehicle {

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " traveling with " + this.className());
    }

    @Override
    public String className() {
        return "Bus";
    }
}

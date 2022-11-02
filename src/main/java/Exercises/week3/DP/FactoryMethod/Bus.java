package Exercises.week3.DP.FactoryMethod;

import Exercises.week3.DP.FactoryMethod.Passenger;
import Exercises.week3.DP.FactoryMethod.Vehicle;

public class Bus extends Vehicle {
    @Override
    public String className() {
        return "Bus";
    }
}

package Exercises.week3.DP.FactoryMethod.Client;

import Exercises.week3.DP.FactoryMethod.Passenger;
import Exercises.week3.DP.FactoryMethod.TravelAgency;

public class Main {

    public static void main(String[] args) {

        TravelAgency travelAgency = TravelAgency.getInstance();

        for(int i = 0; i < 16; i++) {
            Passenger passenger = Passenger.generatePassenger();
            travelAgency.assignPassengers(passenger);
        }

        travelAgency.startTraveling();
    }
}

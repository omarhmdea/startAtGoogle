package Exercises.week3.DP.FactoryMethod;

import Exercises.Utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Passenger {
    private final String name;
    private final VehicleType favorite;
    private static List<String> usedNames = new ArrayList<>();


    public Passenger(String name, VehicleType favoriteVehicle) {
        this.name = name;
        this.favorite = favoriteVehicle;
    }


    public static Passenger generatePassenger() {
        String name = Randoms.randomNameWithoutDuplicate(usedNames);
        usedNames.add(name);
        VehicleType vehicleType = VehicleType.values()[Randoms.randomInt(0,VehicleType.values().length)];
        return new Passenger(name, vehicleType);
    }


    public String getName() {
        return name;
    }


    public VehicleType getFavoriteVehicle() {
        return favorite;
    }
}

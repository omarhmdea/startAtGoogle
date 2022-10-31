package Exercises.week3.DP.FactoryMethod;

import Exercises.Utils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Passenger {
    private final String name;
    private final VehicleType favorite;


    public Passenger(String name, VehicleType favoriteVehicle) {
        this.name = name;
        this.favorite = favoriteVehicle;
    }


    public static Passenger generatePassenger() {
        List<String> names = Arrays.asList("KDB", "Alexis", "Messi", "Hazard", "Benteke", "Mahrez", "Schmeichel", "Aguero", "Sane", "Pogba", "Dier","Omar","Ali","Khaled","Ana","Sami");
        String name = Randoms.randomNameByList(names);
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

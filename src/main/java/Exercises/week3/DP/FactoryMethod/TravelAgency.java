package Exercises.week3.DP.FactoryMethod;

import Exercises.Utils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelAgency {

    private int planeCount = 1;
    private int busCount = 4;
    private int taxiCount = 8;
    private int boatCount = 3;

    private Map<Vehicle, Passenger> vehicleMap;
    private List<VehicleType> availableVehicleTypes;
    private static TravelAgency instance;


    private TravelAgency() {
        availableVehicleTypes = new ArrayList<>();
        vehicleMap = new HashMap<>();
        this.loadAvailableVehicleTypes();
    }

    public static TravelAgency getInstance() {
        if(instance == null) {
            instance = new TravelAgency();
        }

        return instance;
    }


    public void assignPassengers(Passenger passenger) {

        int falg = 0;
        Vehicle vehicle = null;

        switch(passenger.getFavoriteVehicle()) {

            case PLANE:
                if(planeCount > 0) {
                    vehicle = VehicleFactory.createVehicle(VehicleType.PLANE);
                    availableVehicleTypes.remove(VehicleType.PLANE);
                    planeCount--;
                    falg = 1;
                }
                break;
            case BUS:
                if(busCount > 0) {
                    vehicle = VehicleFactory.createVehicle(VehicleType.BUS);
                    availableVehicleTypes.remove(VehicleType.BUS);
                    busCount--;
                    falg = 1;
                }
                break;
            case TAXI:
                if(taxiCount > 0) {
                    vehicle = VehicleFactory.createVehicle(VehicleType.TAXI);
                    availableVehicleTypes.remove(VehicleType.TAXI);
                    taxiCount--;
                    falg = 1;
                }
                break;
            case BOAT:
                if(boatCount > 0) {
                    vehicle = VehicleFactory.createVehicle(VehicleType.BOAT);
                    availableVehicleTypes.remove(VehicleType.BOAT);
                    boatCount--;
                    falg = 1;
                }
                break;
        }

        if(falg == 0) {
            vehicle = randomAvailableAehicle();
        }
        vehicleMap.put(vehicle, passenger);
    }


    private void loadAvailableVehicleTypes() {
        for(int i = 0; i < busCount; i++) {
            availableVehicleTypes.add(VehicleType.BUS);
        }
        for(int i = 0; i < boatCount; i++) {
            availableVehicleTypes.add(VehicleType.BOAT);
        }
        for(int i = 0; i < taxiCount; i++) {
            availableVehicleTypes.add(VehicleType.TAXI);
        }
        for(int i = 0; i < planeCount; i++) {
            availableVehicleTypes.add(VehicleType.PLANE);
        }
    }


    private Vehicle randomAvailableAehicle() {
        VehicleType vehicleType = availableVehicleTypes.get(Randoms.randomInt(0,availableVehicleTypes.size()));
        return VehicleFactory.createVehicle(vehicleType);
    }


    public void startTraveling() {

        for(Map.Entry<Vehicle, Passenger> travel : vehicleMap.entrySet()) {
            travel.getKey().transport(travel.getValue());
        }
    }
}

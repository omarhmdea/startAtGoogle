package Exercises.week3.DP.FactoryMethod;

public class VehicleFactory {

    private static VehicleFactory instance;


    private VehicleFactory() {

    }

    public static VehicleFactory getInstance() {
        if(instance == null) {
            instance = new VehicleFactory();
        }
        return instance;
    }

    public static Vehicle createVehicle(VehicleType type) {
        Vehicle vehicle = null;

        switch(type) {

            case PLANE :
                vehicle =  new Plane();
                break;
            case BUS :
                vehicle = new Bus();
                break;
            case TAXI :
                vehicle = new Taxi();
                break;
            case BOAT :
                vehicle = new Boat();
                break;
        }
        return vehicle;
    }

}

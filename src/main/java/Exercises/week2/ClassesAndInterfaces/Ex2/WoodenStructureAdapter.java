package Exercises.week2.ClassesAndInterfaces.Ex2;

public class WoodenStructureAdapter implements Animal{
    private WoodenHorse woodenHorse;


    public WoodenStructureAdapter(WoodenHorse woodenHorse) {
        this.woodenHorse = woodenHorse;
    }


    @Override
    public String move() {
        return woodenHorse.roll();
    }


    @Override
    public Animal mate(Animal partner) {
        return  new WoodenStructureAdapter(woodenHorse.replicate());
    }


    @Override
    public String ClassName() {
        return "WoodenHorse";
    }
}

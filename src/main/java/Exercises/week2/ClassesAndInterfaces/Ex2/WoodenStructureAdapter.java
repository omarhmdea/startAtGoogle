package Exercises.week2.ClassesAndInterfaces.Ex2;

public class WoodenStructureAdapter implements Animal{
    private WoodenStructures woodenStructures;


    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }


    @Override
    public String move() {
        return woodenStructures.roll();
    }


    @Override
    public Animal mate(Animal partner) {
        return  new WoodenStructureAdapter(woodenStructures.replicate());
    }


    @Override
    public String ClassName() {
        return "WoodenHorse";
    }
}

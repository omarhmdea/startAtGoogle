package Exercises.week3.GoogleTools.AutoValue;

public class Main {

    public static void main(String[] args) {
        Car car = Car.create(123, "red");
        System.out.println(car);

//        Computer build = Computer.builder().setId(1).setMotherBoard("Germane MotherBoard").setHardDick("SSD").setRAM("16GB").build();
//        System.out.println(build);
    }
}

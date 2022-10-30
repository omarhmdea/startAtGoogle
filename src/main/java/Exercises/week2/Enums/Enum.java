package Exercises.week2.Enums;

public class Enum {

    public static void main(String[] args) {
        Enum.singControl(Bird.RAVEN);
        Enum.singControl(Bird.CROW);
        Enum.singControl(Bird.CUCKOO);
        Enum.singControl(Bird.LOON);
    }


    public static void singControl(Bird bird) {
        System.out.println(bird.sing());
    }
}

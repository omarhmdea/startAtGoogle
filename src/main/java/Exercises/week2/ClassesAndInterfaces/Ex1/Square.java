package Exercises.week2.ClassesAndInterfaces.Ex1;

public class Square extends Rectangle{

    public Square(int width, int hight) {
        super(width, hight);
    }

    @Override
    public String className() {
        return "Square";
    }

}

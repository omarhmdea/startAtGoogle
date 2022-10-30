package Exercises.week2.ClassesAndInterfaces.Ex1;

public class Circle extends Shap {

    private final int radius;


    public Circle(int radius) {
        this.radius = radius;
    }


    @Override
    public float area() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public String className() {
        return "Circle";
    }
    @Override
    public String shapDetails() {
        return "radius: " + radius;
    }
}

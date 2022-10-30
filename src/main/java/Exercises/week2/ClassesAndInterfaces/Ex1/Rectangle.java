package Exercises.week2.ClassesAndInterfaces.Ex1;

public class Rectangle extends Shap {

    private final int width;
    private final int height;


    public Rectangle(int width, int hight) {
        this.width = width;
        this.height = hight;
    }

    @Override
    public float area() {
        return width * height;
    }


    @Override
    public String className() {
        return "Rectangle";
    }


    @Override
    public String shapDetails() {
        return "width: " + width + " and height: " + height;
    }
}

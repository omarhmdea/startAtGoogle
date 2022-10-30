package Exercises.week2.ClassesAndInterfaces.Ex1;

public abstract class Shap {

    public abstract float area();


    @Override
    public String toString() {
        return "The is " + this.className() + " with " + this.shapDetails();
    }

    public abstract String shapDetails();
    public abstract String className();
}

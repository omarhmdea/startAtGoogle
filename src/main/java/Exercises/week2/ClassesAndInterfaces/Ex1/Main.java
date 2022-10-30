package Exercises.week2.ClassesAndInterfaces.Ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Shap> shaps = new ArrayList<>();

        shaps.add(new Rectangle(3, 5));
        shaps.add(new Square(5, 5));
        shaps.add(new Circle(4));

        for(Shap s : shaps) {
            System.out.println(s);
        }

    }
}

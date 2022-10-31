package Exercises.week3.GoogleTools.AutoValue;

import com.google.auto.value.AutoValue;
@AutoValue
public abstract class Car {
    static Car create(int id, String color) {
        return new AutoValue_Car(id, color);
    }
    abstract int id();
    abstract String color();
}

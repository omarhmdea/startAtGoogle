package Exercises.week2.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        RandomString str = new RandomString("asd");
        Optional<Object> randomStringInstance = newInstanceSingleString(str);
        System.out.println(randomStringInstance.orElse("no such constructor with one parameter"));

        Stam stam = new Stam();
        Optional<Object> stamInstance = newInstanceSingleString(stam);
        System.out.println(stamInstance.orElse("no such constructor with one parameter"));

    }


    public static Optional<Object> newInstanceSingleString(Object o) {
        Class<?> aClass = o.getClass();
        try {
            Constructor<?> constructor = aClass.getConstructor(String.class);
            Object newObject = constructor.newInstance("Random String");
            return Optional.of(newObject);
        } catch(NoSuchMethodException e) {
            return Optional.empty();
        } catch(InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to instantiate constructor", e);
        }
    }
}

package Exercises.week2.ClassesAndInterfaces.Ex2;

import Exercises.Utils.Randoms;

import java.util.Arrays;

public abstract class AbstractAnimal implements Animal {

    private final int id;
    private final int weight;
    private final Gender gender;


    protected AbstractAnimal(int id, int weight, Gender gender) {
        this.id = id;
        this.weight = weight;
        this.gender = gender;
    }


    public int getId() {
        return id;
    }


    public int getWeight() {
        return weight;
    }


    public Gender getGender() {
        return gender;
    }


    public static Gender generateRandomGender() {
        return Arrays.asList(Gender.values()).get(Randoms.randomInt(2));
    }



    @Override
    public String toString() {
        return "This Animal is " + this.ClassName() + " with " +
                "id = " + id +
                " weight = " + weight +
                " gender = " + gender;
    }
}

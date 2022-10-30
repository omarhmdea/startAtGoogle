package Exercises.week2.ClassesAndInterfaces.Ex2;

import Exercises.Utils.Randoms;

import java.util.Objects;

public class Dog extends AbstractAnimal {


    public Dog(int id, int weight, Gender gender) {
        super(id, weight, gender);
    }


    @Override
    public String move() {
        return "Run";
    }


    @Override
    public String ClassName() {
        return "Dog";
    }


    public static Dog createRandomDog() {
        return new Dog(Randoms.randomInt(1, 100), Randoms.randomInt(40, 200), AbstractAnimal.generateRandomGender());
    }


    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof Dog dog) {
            if(! Objects.equals(this.getGender(), dog.getGender())) {
                return createRandomDog();
            }
        }
        return null;
    }
}

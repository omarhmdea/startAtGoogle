package Exercises.week2.ClassesAndInterfaces.Ex2;

import Exercises.Utils.Randoms;

import java.util.Objects;

public class Cat extends AbstractAnimal {


    public Cat(int id, int weight, Gender gender) {
        super(id, weight, gender);
    }


    public static Cat createRandomCat() {
        return new Cat(Randoms.randomInt(1, 100), Randoms.randomInt(40, 200), AbstractAnimal.generateRandomGender());
    }


    @Override
    public String move() {
        return "Walk";
    }


    @Override
    public String ClassName() {
        return "Cat";
    }


    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof Cat cat) {
            if(! Objects.equals(this.getGender(), cat.getGender())) {
                return createRandomCat();
            }
        }
        return null;
    }
}

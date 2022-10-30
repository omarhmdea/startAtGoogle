package Exercises.week2.ClassesAndInterfaces.Ex2;

import Exercises.Utils.Randoms;

import java.util.Objects;

public class Cow extends AbstractAnimal {


    public Cow(int id, int weight, Gender gender) {
        super(id, weight, gender);
    }


    public static Cow createRandomCow() {
        return new Cow(Randoms.randomInt(1, 100), Randoms.randomInt(40, 200), AbstractAnimal.generateRandomGender());
    }


    @Override
    public String move() {
        return "Walk slowly";
    }


    @Override
    public String ClassName() {
        return "Cow";
    }


    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof Cow cow) {
            if(! Objects.equals(this.getGender(), cow.getGender())) {
                return createRandomCow();
            }
        }
        return null;
    }
}

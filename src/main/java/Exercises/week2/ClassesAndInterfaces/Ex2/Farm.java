package Exercises.week2.ClassesAndInterfaces.Ex2;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private final List<Animal> animals;


    public Farm() {
        this.animals = new ArrayList<>();
    }


    public void addAnimal(Animal animal) {
        animals.add(animal);
    }


    public void acquire(String animalType) {

        Animal newAnimal = switch(animalType) {
            case "Cat" -> Cat.createRandomCat();
            case "Dog" -> Dog.createRandomDog();
            case "Cow" -> Cow.createRandomCow();
            default -> null;
        };

        if(newAnimal == null) {
            System.out.println("Farm doesn't support This type of animal [ " + animalType + " ]");
        }

    }


    public Animal mate(Animal other) {
        Animal newAnimal = null;
        for(Animal animal : animals) {
            newAnimal = other.mate(animal);
            if(newAnimal != null) {
                animals.add(newAnimal);
                return newAnimal;
            }
        }

        return newAnimal;
    }


    public List<Animal> getAnimals() {
        return animals;
    }


    @Override
    public String toString() {
        String str = "";
        str += "animals = [";
        for(Animal animal : animals) {
            str += animal.ClassName() + " ";
        }
        str += "] \n";
        return str;
    }

}

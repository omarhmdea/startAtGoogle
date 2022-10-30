package Exercises.week2.ClassesAndInterfaces.Ex2;

public class Main {

    public static void main(String[] args) {

        Animal cat = Cat.createRandomCat();
        Animal dog = Dog.createRandomDog();
        Animal cow = Cow.createRandomCow();

        Farm farm = new Farm();

        farm.addAnimal(cat);
        farm.addAnimal(dog);
        farm.addAnimal(cow);

        Farmar farmar = new Farmar(farm);

        // farmer can make an animal move
        farmar.move(cow);

        // mate method
        Animal dog2 = farm.mate(Dog.createRandomDog());

        if(dog2 != null) {
            System.out.println(dog2);
        }
        else {
            System.out.println("Can't mate this " + dog.ClassName() + "s because they same gender");
        }

        // acquire
        farm.acquire("Cat");
        farm.acquire("Cat");
        farm.acquire("khaled");
        System.out.println(farm);


    }
}

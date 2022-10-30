package Exercises.week2.LambdasAndStreams.StockService;

import Exercises.Utils.Randoms;

import java.time.LocalDate;
import java.util.Arrays;


class Item implements Comparable<Item> {

    private final String name;
    private final ProductType type;
    private final LocalDate expirationDate;
    private final int weight;


    public Item(String name, ProductType type, LocalDate expirationDate, int weight) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
        this.weight = weight; // Validation !!!!!!!!!!!!!!
    }


    public static Item createRandomItem() {
        ProductType type = Randoms.randomEnum(ProductType.values());
        String name = null;

        switch(type) {

            case FURNITURE -> name = Randoms.randomNameByList(Arrays.asList("Chair", "Table", "Sofa", "Door"));
            case FOOD -> name = Randoms.randomNameByList(Arrays.asList("Fish", "Chicken", "Potatoes", "Broccoli"));
            case ELECTRONIC -> name = Randoms.randomNameByList(Arrays.asList("Ps4", "TV", "Pc", "Mobile"));
            case CAR -> name = Randoms.randomNameByList(Arrays.asList("BMW", "Nissan", "Toyota", "Honda"));
        }

        LocalDate expirationDate = LocalDate.now().plusDays(Randoms.randomInt(- 356, 356));
        int weight = Randoms.randomInt(20);
        return new Item(name, type, expirationDate, weight);
    }


    public String getName() {
        return name;
    }


    public ProductType getType() {
        return type;
    }


    public LocalDate getExpirationDate() {
        return expirationDate;
    }


    public int getWeight() {
        return weight;
    }


    @Override
    public int compareTo(Item o) {
        return this.getExpirationDate().compareTo(o.getExpirationDate());
    }


    @Override
    public String toString() {
        String str = "";
        str += "[ name = " + name + ", ";
        str += " type = " + type + ", ";
        str += "expiration Date = " + expirationDate + ", ";
        str += " weight = " + weight + " ]";
        return str;
    }
}

package Exercises.Utils;

import Exercises.week2.LambdasAndStreams.StockService.ProductType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Randoms {

    private static List<String> names = new ArrayList<>(Arrays.asList("KDB", "Alexis", "Messi", "Hazard", "Benteke", "Mahrez", "Schmeichel", "Aguero", "Sane", "Pogba", "Dier","Omar","Ali","Khaled","Ana","Sami"));


    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static int randomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }


    public static String randomNameByList(List<String> names) {

        List<String> availableNames = new ArrayList<>(names);
        return availableNames.get(Randoms.randomInt(availableNames.size()));
    }

    public static String randomNameWithoutDuplicate(List<String> usedNames) {
        names.removeAll(usedNames);
        return names.get(Randoms.randomInt(names.size()));
    }

    public static <T> T randomEnum(T[] collection) {
        return collection[Randoms.randomInt(ProductType.values().length)];
    }

}

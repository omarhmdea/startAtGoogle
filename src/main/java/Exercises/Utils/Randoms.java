package Exercises.Utils;

import Exercises.week2.LambdasAndStreams.StockService.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Randoms {

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

    public static <T> T randomEnum(T[] collection) {
        return collection[Randoms.randomInt(ProductType.values().length)];
    }

}

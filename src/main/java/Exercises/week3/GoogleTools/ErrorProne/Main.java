package Exercises.week3.GoogleTools.ErrorProne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> s1 = Arrays.asList("a","b","c");
        List<String> s2 = Arrays.asList("a","b","c");

        System.out.println(s1.equals(s2));

    }
    public static boolean compare(String firstList[], String secondList[]) {
        return firstList.equals(secondList);
    }
}

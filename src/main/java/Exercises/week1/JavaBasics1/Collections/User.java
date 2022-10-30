package Exercises.week1.JavaBasics1.Collections;

import Exercises.Utils.Person;

import java.util.Random;


public class User extends Person {
    private boolean IsActivated;

    public User(String name, int id, boolean isActivated) {
        super(name, id);
        IsActivated = isActivated;
    }

    public boolean getIsActivated() {
        return IsActivated;
    }

    public void setIsActivated(boolean activated) {
        IsActivated = activated;
    }

    public static String getRandomName(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

}
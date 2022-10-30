package Exercises.week1.JavaBasics1.Collections;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Collections {
    public static void main(String[] args) {


        Map<Integer, User> users = new HashMap<>();

        users.put(1, generateRandomUser());
        users.put(2, generateRandomUser());
        users.put(3, generateRandomUser());
        users.put(4, generateRandomUser());
        users.put(5, generateRandomUser());

        printUsers(users);

        List<User> userList = new ArrayList<User>(users.values());
        User u = userList.get(1);

        System.out.println();
        printSingleUser(u);

        int count = 0;
        for (User user : users.values()) {
            if (user.getIsActivated()) {
                count++;
            }
        }
        System.out.println(count + " activated users.");



    }

    public static User generateRandomUser() {
        String userName = User.getRandomName(5);
        int userId = ThreadLocalRandom.current().nextInt(100);
        boolean userIsActivated = ThreadLocalRandom.current().nextBoolean();

        return new User(userName, userId, userIsActivated);
    }

    public static void printSingleUser(User u){
        System.out.println("My Name is : " + u.getName() + " with id : " + u.getId());
    }
    public static void printUsers(Map<Integer, User> users) {
        for (User u : users.values()) {
            printSingleUser(u);
        }
    }

}

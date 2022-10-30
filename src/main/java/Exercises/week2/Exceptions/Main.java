package Exercises.week2.Exceptions;

public class Main {

    public static void main(String[] args) {

        ConfigurationFile file = new ConfigurationFile();
        file.openConfigurationFile("/Users/omarhmdea/Desktop/startAtGoogle /src/main/java/Exercises/week2/Exceptions/Configuration File.json");

        System.out.println(file.getData());
        System.out.println(file.getKey("vm"));
    }
}

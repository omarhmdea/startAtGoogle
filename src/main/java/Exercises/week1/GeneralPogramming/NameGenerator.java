package Exercises.week1.GeneralPogramming;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NameGenerator {

    private List<String> names;


    public static List<String> generteNamesByList(List<String> names) {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.setNames(names);
        return nameGenerator.getNames();
    }


    public static List<String> generteNamesByFile(String pathOfFileNames) {
        NameGenerator nameGenerator = new NameGenerator();

        try(Scanner scanner = new Scanner(new FileReader(pathOfFileNames));) {
            while(scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        //nameGenerator.setNames(names);
        return nameGenerator.getNames();
    }


    public List<String> getNames() {
        return names;
    }


    public void setNames(List<String> names) {
        this.names = new ArrayList<>(names);
    }
}

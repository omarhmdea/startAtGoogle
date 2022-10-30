package Exercises.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileUtils {

    public static BufferedReader readFile(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            return new BufferedReader(fileReader);

        } catch(FileNotFoundException e) {
            throw new RuntimeException("there is no such file in this path " + path);
        }
    }
}

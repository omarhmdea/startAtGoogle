package Exercises.week2.Generics;

import Exercises.Utils.FileUtils;
import Exercises.Utils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class readLineFromFile implements Callable<String> {

    private final String path;


    public readLineFromFile(String path) {
        this.path = path;
    }


    @Override
    public String call() throws Exception {

        ArrayList<String> lines = new ArrayList<>();
        String line = null;

        try(BufferedReader bufferedReader = FileUtils.readFile(path);) {
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch(IOException e) {
            throw new RuntimeException("Something wrong happened");
        }

        return lines.get(Randoms.randomInt(lines.size()));
    }
}

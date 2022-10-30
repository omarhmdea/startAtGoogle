package Exercises.week2.Exceptions;

import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class ConfigurationFile {

    private Map<String, String> data;


    public void openConfigurationFile(String path) {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {

            Gson gson = new Gson();
            data = gson.fromJson(bufferedReader, Map.class);

        } catch(FileNotFoundException e) {
            System.out.println("File not found, creating default configuration file");
            createFileWithDefaultConfiguration(path);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void createFileWithDefaultConfiguration(String path) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));) {

            data = new HashMap<>();
            data.put("appname", "application");
            data.put("Version", "0.1.0");
            data.put("UUID", "300V");

            Gson gson = new Gson();
            gson.toJson(data, bufferedWriter);

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            throw new RuntimeException("Something wrong happened");
        }
    }


    public Map<String, String> getData() {
        if(data == null) {
            throw new IllegalStateException("file is not initialized");
        }
        return data;
    }


    public Object getKey(String key) {
        if(getData().get(key) != null) {
            return data.get(key);
        }
        throw new IllegalArgumentException("This key doesn't exits [" + key + "]");
    }
}

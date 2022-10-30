package Exercises.week2.Generics;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) throws Exception {
        String path = "/Users/omarhmdea/Desktop/startAtGoogle /src/main/java/Exercises/week2/Generics/staf.txt";
        Callable<String> getFirstLineFromFile = new readLineFromFile(path);
        String res = retry(getFirstLineFromFile, "Khaled wani", 5, 100);
        System.out.println(res);

        Callable<Integer> equationSolver = new EquationSolver("x+1=5", Arrays.asList(2, 3, 4,5,6));
        Integer res2 = retry(equationSolver, 4);
        System.out.println(res2);


    }


    public static <T> T retry(Callable<T> action, T expectedResult, int retries, long sleepTime) throws Exception {

        T callResult = action.call();
        while(retries > 0) {
            if(callResult.equals(expectedResult)) {
                return expectedResult;
            }
            callResult = action.call();
            Thread.sleep(sleepTime);
            retries--;
        }
        return callResult;
    }


    public static <T> T retry(Callable<T> action, T expectedResult) throws Exception {

        int retries = 4;
        T callResult = action.call();
        while(retries > 0) {
            if(callResult.equals(expectedResult)) {
                return expectedResult;
            }
            callResult = action.call();
            Thread.sleep(100);
            retries--;
        }
        return callResult;
    }
}

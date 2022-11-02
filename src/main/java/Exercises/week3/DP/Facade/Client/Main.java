package Exercises.week3.DP.Facade.Client;

import Exercises.week3.DP.Facade.HTTPFacade;
import Exercises.week3.DP.Facade.ResponeWapper;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Map<String, String> paramsMap = new HashMap<>();

        // Get request
        HTTPFacade.get("https://reqres.in/api/users/2");

        // Post request
        paramsMap.put("email", "eve.holt@reqres.in");
        paramsMap.put("name", "pistol");
        HTTPFacade.post("https://reqres.in/api/register", paramsMap);

        // Put request
        paramsMap.put("name", "morpheus");
        paramsMap.put("job", "zion resident");
        HTTPFacade.put("https://reqres.in/api/register", paramsMap);

        // Patch request
        paramsMap.put("name", "morpheus");
        paramsMap.put("job", "zion resident");
        HTTPFacade.put("https://reqres.in/api/users/2", paramsMap);

        //delete
        HTTPFacade.patch("https://reqres.in/api/users/2", paramsMap);
    }
}

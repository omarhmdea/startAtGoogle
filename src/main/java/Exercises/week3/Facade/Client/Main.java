package Exercises.week3.Facade.Client;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.hc.client5.http.config.RequestConfig.custom;
import static org.apache.hc.client5.http.cookie.StandardCookieSpec.STRICT;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://reqres.in/api/users/2";

        HttpGet httpGet = new HttpGet(url.toString());
        httpGet.addHeader("user-agent", "Apache-HttpClient/5.0");
        httpGet.addHeader("accept-encoding", "gzip, deflate, br");
        httpGet.addHeader("cache-control", "max-age=0");

        RequestConfig requestConfig = custom().build();
        httpGet.setConfig(requestConfig);
        System.out.println(httpGet.getEntity().getContent());
    }
}

package Exercises.week3.DP.Facade;


import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HTTPFacade {


    public static void get(String url) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);

        System.out.println("Request Type: "+httpget.getMethod());
        CloseableHttpResponse httpresponse = httpclient.execute(httpget);

        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

    }

    public static void post(String url, Map<String, String> parmsMap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        for(Map.Entry<String, String> parm : parmsMap.entrySet()) {
            params.add(new BasicNameValuePair(parm.getKey(), parm.getValue()));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

        CloseableHttpResponse httpresponse = httpclient.execute(httpPost);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }

    public static void put(String url, Map<String, String> parmsMap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut HttpPut = new HttpPut(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        for(Map.Entry<String, String> parm : parmsMap.entrySet()) {
            params.add(new BasicNameValuePair(parm.getKey(), parm.getValue()));
        }
        HttpPut.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

        CloseableHttpResponse httpresponse = httpclient.execute(HttpPut);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }

    public static void patch(String url, Map<String, String> parmsMap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPatch HttpPatch = new HttpPatch(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        for(Map.Entry<String, String> parm : parmsMap.entrySet()) {
            params.add(new BasicNameValuePair(parm.getKey(), parm.getValue()));
        }
        HttpPatch.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

        CloseableHttpResponse httpresponse = httpclient.execute(HttpPatch);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }

    public static void delete(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete HttpDelete = new HttpDelete(url);

        CloseableHttpResponse httpresponse = httpclient.execute(HttpDelete);
        System.out.println("Status code: " + httpresponse.getCode());

    }


}

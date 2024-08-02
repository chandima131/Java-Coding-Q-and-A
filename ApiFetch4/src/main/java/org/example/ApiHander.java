package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiHander {

    public static String apiConnectionHandler(String api) throws Exception{

        //Cretae the connection
        URL url =new URL(api);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // int status = connection.getResponseCode();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuilder content = new StringBuilder();

        while ((lines = br.readLine()) !=null){
            content.append(lines);
        }
        br.close();

        return (content.toString());


    }
}

package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    public static String getApiResponse(String api) throws Exception{


        //Cretae the connection
        URL url = new URL(api);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // receive data
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuilder content = new StringBuilder();

        while ((lines = br.readLine()) !=null){
            content.append(lines);
        }
        br.close();
        connection.disconnect();

        return content.toString();
    }
}
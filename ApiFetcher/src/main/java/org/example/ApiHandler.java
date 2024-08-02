package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiHandler {

    // apiURL = http://bored.api.lewagon.com/api/activity?key=5881028
    public String sendGetRequest(String apiURL) throws Exception{


        //URL Object
        URL url = new URL(apiURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();

        if(status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_MOVED_TEMP){

            String reDirectedUrl = connection.getHeaderField("location");

            connection = (HttpURLConnection) new URL(reDirectedUrl).openConnection();
            connection.setRequestMethod("GET");

            status = connection.getResponseCode();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String readLine;
        StringBuilder content = new StringBuilder();

        while ((readLine = br.readLine() )!=null){
            content.append(readLine);
        }

        br.close();


        return content.toString();
    }

}

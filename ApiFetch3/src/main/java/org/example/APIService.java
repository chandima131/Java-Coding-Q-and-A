package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class APIService {

    public String getApi(String api) throws Exception{

            //Create the connection
            URL url = new URL(api);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();

            // Read data
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String redLines;
            StringBuilder content = new StringBuilder();

            while ((redLines = br.readLine()) !=null){
                content.append(redLines);
            }
            br.close();

            return  (content.toString());
    }

    public void fetchSeveralApi() throws Exception{

        String api = "http://www.boredapi.com/api/activity/";
        Set <String> set = new HashSet<>();

        while (set.size() < 5){
            String response = getApi(api);
            set.add(response);
        }
        for (String s: set){
            System.out.println(s);
        }
    }
}

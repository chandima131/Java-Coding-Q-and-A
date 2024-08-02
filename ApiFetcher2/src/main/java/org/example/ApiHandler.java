package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiHandler {

    public String getResponse(String api) throws Exception{

            //URL Object
            URL url = new URL(api);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();

            if (status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_MOVED_TEMP) {

                String newApiUrl = connection.getHeaderField("location");

                connection = (HttpURLConnection) new URL(newApiUrl).openConnection();
                connection.setRequestMethod("GET");
                status = connection.getResponseCode();
            }

            // read the data

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String readLine;
            StringBuilder content = new StringBuilder();

            while ((readLine = br.readLine()) != null) {
                content.append(readLine);
            }
            br.close();

           // System.out.println(content.toString());


            return content.toString();
        }
}

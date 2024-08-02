package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ApiFetcher {
    public static void main(String[] args) {
        try {
            // Step 1: Define the API endpoint
            String apiUrl = "http://bored.api.lewagon.com/api/activity/";

            // Step 2: Create a URL object
            URL url = new URL(apiUrl);

            // Step 3: Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Step 4: Set the request method
            connection.setRequestMethod("GET");

            // Step 5: Get the response code
            int responseCode = connection.getResponseCode();

            // Step 6: If response is successful, read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Step 7: Parse the JSON response
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);

                // Step 8: Print the formatted response
                System.out.println("Activity: " + jsonResponse.get("activity").getAsString());
                System.out.println("Type: " + jsonResponse.get("type").getAsString());
                System.out.println("Participants: " + jsonResponse.get("participants").getAsInt());
                System.out.println("Price: " + jsonResponse.get("price").getAsDouble());
                System.out.println("Accessibility: " + jsonResponse.get("accessibility").getAsDouble());
                String link = jsonResponse.has("link") && !jsonResponse.get("link").isJsonNull() ? jsonResponse.get("link").getAsString() : "No link provided";
                System.out.println("Link: " + link);
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

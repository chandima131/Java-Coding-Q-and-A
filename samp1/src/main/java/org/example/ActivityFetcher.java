package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityFetcher {
    private static final String BASE_API_URL = "https://bored.api.lewagon.com/api/activity?key=";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide an activity key as a command line argument.");
            System.exit(1);
        }
        String key = args[0];
        try {
            fetchAndDisplayActivityByKey(key);
        } catch (IOException e) {
            System.err.println("Error fetching activity: " + e.getMessage());
        }
    }

    public static void fetchAndDisplayActivityByKey(String key) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(BASE_API_URL + key);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
            Gson gson = new Gson();
            JsonObject activityObject = gson.fromJson(reader, JsonObject.class);

            int participants = activityObject.get("participants").getAsInt();
            if (participants == 1) {
                System.out.println("Activity: " + activityObject.get("activity").getAsString());
                System.out.println("Type: " + activityObject.get("type").getAsString());
                System.out.println("Participants: " + participants);
                System.out.println("Price: " + activityObject.get("price").getAsDouble());
                System.out.println("Link: " + activityObject.get("link").getAsString());
                System.out.println("Accessibility: " + activityObject.get("accessibility").getAsDouble());
                System.out.println("-------------");
            }
            reader.close();
        } else {
            System.err.println("Failed to fetch activity. HTTP Error code: " + statusCode);
        }
        httpClient.close();
    }
}

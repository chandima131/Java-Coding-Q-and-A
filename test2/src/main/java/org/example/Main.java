package org.example;

import com.google.gson.JsonObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BoredAPI api = new BoredAPI();
        try {
            JsonObject activity = api.getRandomActivity();
            System.out.println("Activity: " + activity.get("activity").getAsString());
            System.out.println("Type: " + activity.get("type").getAsString());
            System.out.println("Participants: " + activity.get("participants").getAsInt());
            if (activity.has("price")) {
                System.out.println("Price: " + activity.get("price").getAsDouble());
            }
            if (activity.has("link")) {
                System.out.println("Link: " + activity.get("link").getAsString());
            }
            if (activity.has("key")) {
                System.out.println("Key: " + activity.get("key").getAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

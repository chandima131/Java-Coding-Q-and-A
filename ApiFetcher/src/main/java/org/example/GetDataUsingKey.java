package org.example;

import com.google.gson.JsonObject;

import java.util.Scanner;

public class GetDataUsingKey {

public static void main (String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter the key that you required");
    String key = sc.nextLine();

    try {

        ApiHandler apiHandler = new ApiHandler();
        JsonResponseProcessor jsonResponseProcessor = new JsonResponseProcessor();

        String apiKey = "http://bored.api.lewagon.com/api/activity?type=" + key;

        String responce = apiHandler.sendGetRequest(apiKey);

        JsonObject jsonObject = jsonResponseProcessor.parseJsonObject(responce);

        System.out.println(jsonObject);





    } catch (Exception e){
        e.getStackTrace();
    }
}
}

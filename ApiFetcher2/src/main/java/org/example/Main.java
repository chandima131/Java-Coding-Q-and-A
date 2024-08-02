package org.example;

import com.google.gson.JsonObject;


public class Main {
    public static void main(String args[]){
    try {
        String apiUrl = "http://bored.api.lewagon.com/api/activity/";
        ApiHandler apiHandler = new ApiHandler();
        CreateJsonObject jsonObject = new CreateJsonObject();

        String abc = apiHandler.getResponse(apiUrl);
        JsonObject obj = jsonObject.returnJasonObject(abc);


        System.out.println(obj);


    } catch (Exception e){
        e.getStackTrace();
    }

    }
}
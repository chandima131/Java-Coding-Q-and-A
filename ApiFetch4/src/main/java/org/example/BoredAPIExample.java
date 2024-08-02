package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class BoredAPIExample {
    public static void main(String[] args) {
        //ApiHander apiHander = new ApiHander();
        BoredAPIExample example = new BoredAPIExample();
        example.run();
    }

// handle the functions
    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bored API Example:");
        System.out.println("1. Fetch a random activity");
        System.out.println("Enter your choise");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                fetchRandomActivity();
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }


    //Fetch a random activity
    public void fetchRandomActivity(){
        try {
            String api = "https://bored.api.lewagon.com/api/activity/";
            String responce = ApiHander.apiConnectionHandler(api);
            JsonObject object = JsonParser.parseString(responce).getAsJsonObject();
            System.out.println(object);
        } catch (Exception e){
            e.getStackTrace();
        }
    }


}
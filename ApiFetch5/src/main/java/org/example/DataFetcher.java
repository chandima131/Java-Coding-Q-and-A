package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DataFetcher {
    public static void main(String args[]){

        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.run();
        //dataFetcher.fetchActivityByKey();

    }
    public void run(){

        System.out.println("Please Enter a number to receive data:");
        System.out.println("1: Fetch Random Activity");
        System.out.println("2: Fetch Activity By Key");
        System.out.println("3: Fetch Activity By Type");
        System.out.println("4:");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();

        switch (input){
            case 1:
                fetchRandomActivity();
                break;
            case 2:
                System.out.print("Enter key: ");
                String key = sc.nextLine();
                fetchActivityByKey(key);
                break;

            case 3:
                System.out.print("Enter Type: ");
                String type = sc.nextLine();
                fetchActivityByType(type);
                break;

            case 4:
                System.out.print("Enter Participants: ");
                int participant = sc.nextInt();
                sc.nextLine();
                fetchActivityByParticipant(participant);
                break;


            default:
                System.out.println("Entered a wrong number");


        }


    }


    public void fetchRandomActivity(){
        try{
            String api = "https://bored.api.lewagon.com/api/activity/";
            String response = ApiService.getApiResponse(api);
            JsonObject object = JsonParser.parseString(response).getAsJsonObject();

            System.out.println(object);
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    //Fetch activity by key

    public void fetchActivityByKey(String key){
        try {
            String api = "https://bored.api.lewagon.com/api/activity?key=" + key;
            String response = ApiService.getApiResponse(api);
            JsonObject obj = JsonParser.parseString(response).getAsJsonObject();

            System.out.println(response);

        } catch (NumberFormatException e){
            System.out.println("Entered an invalid number. ");
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    //Fetch activity by type

    public void fetchActivityByType(String type){
        try {
            String api = "https://bored.api.lewagon.com/api/activity?type=" + type;
            String response = ApiService.getApiResponse(api);
            JsonObject obj = JsonParser.parseString(response).getAsJsonObject();

            System.out.println(response);

        } catch (Exception e){
            e.getStackTrace();
        }
    }

    //Fetch activity by participants
    public void fetchActivityByParticipant(int i){
        try {
            String api = "https://bored.api.lewagon.com/api/activity?participants=" + i;
            String response = ApiService.getApiResponse(api);
            JsonObject obj = JsonParser.parseString(response).getAsJsonObject();

            System.out.println(response);

        } catch (NumberFormatException num){
            System.out.println("Please Enter a Valid Input");
        } catch(Exception e){
            e.getStackTrace();
        }
    }
}

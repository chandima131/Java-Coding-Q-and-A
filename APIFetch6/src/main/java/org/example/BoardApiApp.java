package org.example;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardApiApp {
    public static void main(String[] args) {
        BoardApiApp boardApiApp = new BoardApiApp();
        boardApiApp.run();
    }

    public void run(){

        //fetchActivity();
                Scanner sc = new  Scanner(System.in);
        System.out.println("Enter number of queries that we need:");
        int queries = sc.nextInt();
        System.out.println("enter the partipant number");
        int participant = sc.nextInt();
        sc.nextLine();

        fetchMultipleParticipants(queries,participant);

    }

    // api activity
    public void fetchActivity(){

        try{
            String api = "https://bored.api.lewagon.com/api/activity/";
            String response = ApiHandler.getApiRequest(api);
            System.out.println(response);

        } catch (Exception e){
            e.getStackTrace();
        }
    }

    //multiple api which participant less than 5

    public void fetchMultipleParticipants(int queries, int participants){
        try{
            List<JsonObject> list = new ArrayList<>();

            for (int i=1; i<=queries; i++){
                String api = "https://bored.api.lewagon.com/api/activity?participants=" +participants;
                String response = ApiHandler.getApiRequest(api);
                JsonObject obj = JsonParser.parseString(response).getAsJsonObject();
                if(obj.has("participants") && obj.get("participants").getAsInt() <12){
                    list.add(obj);
                }

            }
            for (JsonObject s: list){
                System.out.println(s);
            }


        } catch (Exception e){
            e.getStackTrace();
        }

    }

}
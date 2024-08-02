package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static String fectchActivity() throws Exception{

        APIService apiService = new APIService();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a Activity Type");
        String input = sc.nextLine();
        sc.close();

        String api = "https://bored.api.lewagon.com/api/activity?type="+input;

        return (apiService.getApi(api));

    }

    public static void getPriceRange(){

        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("Please Enter Min Price:");
            double minPrice = Double.parseDouble(sc.nextLine());

            System.out.println("Please Enter the Max Price:");
            double maxPrice = Double.parseDouble(sc.nextLine());
            sc.close();

            APIService apiService = new APIService();
            String api = "https://bored.api.lewagon.com/api/activity?minPrice=" + minPrice + "&maxPrice=" + maxPrice;
            System.out.println(apiService.getApi(api));

        } catch (NumberFormatException e){
            System.out.println("Please Enter Valid Input");
        } catch (Exception e){
            e.getStackTrace();
        }

    }

public static JsonObject parseJson(String api){
    JsonObject jsonObject = JsonParser.parseString(api).getAsJsonObject();
    return jsonObject;
}

public static void retrewmultipleActivities() throws Exception{
        APIService apiService = new APIService();

            apiService.fetchSeveralApi();


}
    public static void main(String[] args) {

        try {


            //Create a program that fetches an activity based on user input for type (e.g., recreational, educational).

            String output = fectchActivity();
            //retrewmultipleActivities();



        } catch (Exception e){
            e.getStackTrace();
        }
    }
}
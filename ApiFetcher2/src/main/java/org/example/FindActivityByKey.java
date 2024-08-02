package org.example;

import com.google.gson.JsonObject;

import java.util.Scanner;

public class FindActivityByKey {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);


        try {
            System.out.println("please enter the Min Price");
            String minPriceS = sc.nextLine();
            double minP = Double.parseDouble(minPriceS);

            System.out.println("please enter the Max Price");
            String maxPriceS = sc.nextLine();
            double maxP = Double.parseDouble(maxPriceS);

            String apiUrl = "http://bored.api.lewagon.com/api/activity?minprice=" + minP + "&maxprice=" + maxP;

            ApiHandler apiHandler = new ApiHandler();
            CreateJsonObject object = new CreateJsonObject();

            JsonObject abc = object.returnJasonObject(apiHandler.getResponse(apiUrl));

            System.out.println(abc);


        } catch (NumberFormatException numberFormatException){
            System.out.println("Invalid Input");
        }
        catch (Exception e){
            e.getStackTrace();
        }

    }
}

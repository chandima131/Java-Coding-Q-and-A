package org.example;

public class Main {
    public static void main(String[] args) {
        ApiService boredApiService = new ApiService();

        try {
            Activity activity = boredApiService.getRandomActivity();
            System.out.println(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

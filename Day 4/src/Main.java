import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        String fileName = "data.txt";
//        Map<String, List<Integer>> studentScores = new HashMap<>();
//
//        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
//            String line;
//            while ((line = br.readLine()) != null){
//                String[] parts = line.split(", ");
//                String student = parts[0];
//                int score = Integer.parseInt(parts[2]);
//
//                studentScores.computeIfAbsent(student, k -> new ArrayList<>()).add(score);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//
//    Map <String,Double> avarageScore = new HashMap<>();
//
//        for(Map.Entry<String,List<Integer>> entry : studentScores.entrySet()){
//
//            List <Integer> scores = entry.getValue();
//
//            //calculate the sum of scores
//            int sum =0;
//            for (int score: scores){
//                sum += score;
//            }
//
//            // calculate the average
//
//            double average = 0.0;
//            if(!scores.isEmpty()){
//                average = (double) sum/scores.size();
//            }
//
//            avarageScore.put(entry.getKey(),average);
//        }
//
//        for(Map.Entry<String,Double> entry : avarageScore.entrySet()){
//
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//
//        }


        String file = "data.txt";

        Map <String, List<Integer>> studentScore = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;

            while ((line = br.readLine()) != null){

                String[] parts = line.split(", ");

                String name = parts[0];
                Integer score = Integer.parseInt(parts[2]);

                if(!studentScore.containsKey(name)){
                    studentScore.put(name, new ArrayList<>());
                }

                studentScore.get(name).add(score);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

   //Display Data
    for(Map.Entry<String, List<Integer>> entry : studentScore.entrySet()){
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    //Get Avarage
        List <Integer> scores = new ArrayList<>();
        Map <String,Double> averageScore = new HashMap<>();

        for(Map.Entry<String, List<Integer>> entry : studentScore.entrySet()){

            int sum =0;
            scores = entry.getValue();

            for(int score: scores){
                sum += score;
            }

            //get avarage

            double average = (double) sum/scores.size();

            averageScore.put(entry.getKey(),average);

        }

        //Display Data
        for(Map.Entry<String, Double> entry : averageScore.entrySet()){
            System.out.printf("%s: %.2f%n" ,entry.getKey() ,entry.getValue());
        }
    }
}
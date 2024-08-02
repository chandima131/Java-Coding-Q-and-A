import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class ApiFetcher {
    public static void main(String[] args) {
        try {
            // Step 1: Define the API endpoint
            String apiUrl = "http://bored.api.lewagon.com/api/activity/";

            // Step 2: Create a URL object
            URL url = new URL(apiUrl);

            // Step 3: Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Step 4: Set the request method
            connection.setRequestMethod("GET");

            // Step 5: Get the response code
            int responseCode = connection.getResponseCode();

            // Step 6: If response is successful, read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Step 7: Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Step 8: Print the formatted response
                System.out.println("Activity: " + jsonResponse.getString("activity"));
                System.out.println("Type: " + jsonResponse.getString("type"));
                System.out.println("Participants: " + jsonResponse.getInt("participants"));
                System.out.println("Price: " + jsonResponse.getDouble("price"));
                System.out.println("Accessibility: " + jsonResponse.getDouble("accessibility"));
                String link = jsonResponse.optString("link", "No link provided");
                System.out.println("Link: " + link);
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

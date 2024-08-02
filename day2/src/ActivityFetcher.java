import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ActivityFetcher {
    public static void main(String[] args) {
        // Check if an activity key is provided as a command line argument
        if (args.length != 1) {
            System.out.println("Usage: java ActivityFetcher <activity_key>");
            return;
        }

        String activityKey = args[0];
        String apiUrl = "https://bored.api.lewagon.com/api/activity?key=" + activityKey;

        // Create an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest instance
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        // Send the request and get the response
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}

package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.StringReader;

public class BoredAPI {
    private static final String BASE_URL = "https://www.boredapi.com/api/activity";

    public JsonObject getRandomActivity() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(BASE_URL);
        CloseableHttpResponse response = httpClient.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        String contentType = response.getEntity().getContentType().getValue();
        String jsonResponse = EntityUtils.toString(response.getEntity());

        System.out.println("Status Code: " + statusCode);
        System.out.println("Content Type: " + contentType);
        System.out.println("Raw JSON response: " + jsonResponse);  // Print the raw JSON response

        // Check if the response status code is 200 (OK) and the content type is JSON
        if (statusCode == 200 && contentType.contains("application/json")) {
            // Enable lenient parsing
            JsonReader reader = new JsonReader(new StringReader(jsonResponse));
            reader.setLenient(true);
            return JsonParser.parseReader(reader).getAsJsonObject();
        } else {
            throw new IOException("Unexpected response from the API: " + jsonResponse);
        }
    }
}

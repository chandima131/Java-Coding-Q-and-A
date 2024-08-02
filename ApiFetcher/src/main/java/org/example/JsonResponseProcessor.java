package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonResponseProcessor {

    public JsonObject parseJsonObject(String response){

        return JsonParser.parseString(response).getAsJsonObject();
    }
}

package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class CreateJsonObject {

    public JsonObject returnJasonObject(String content){
        return JsonParser.parseString(content).getAsJsonObject();
    }
}

package com.baymax.baymax.utils.common;

import java.lang.reflect.Type;
import com.google.gson.Gson;

public class JsonUtil{
    // Gson is thread safe: 
    // http://stackoverflow.com/questions/10380835/is-it-ok-to-use-gson-instance-as-a-static-field-in-a-model-bean-reuse
    private static Gson gson = new Gson();
    
    public static String Serialize(Object src){
        return gson.toJson(src);
    }
    
    public static Object DeSerialize(String json, Type typeOfT){
        return gson.fromJson(json, typeOfT);
    }
}
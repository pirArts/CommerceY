package com.baymax.baymax.utils.marshaller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * IDEA 14
 * Created by qiqidone on 15-7-22.
 */
public class JsonMarshaller {
    private final static Logger logger = LoggerFactory.getLogger(JsonMarshaller.class);
    private static Gson gson = new Gson();


    static public Object fromJson(String stream, Class clazz){
        return gson.fromJson(stream, clazz);
    }

    static public String toJson(Object obj){
        return gson.toJson(obj);
    }

}

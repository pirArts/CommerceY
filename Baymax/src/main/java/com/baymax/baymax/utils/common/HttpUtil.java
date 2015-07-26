package com.baymax.baymax.utils.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpUtil{
    public static String GetContentFromUrl(String url, HashMap<String, String> paramKeyValuePair) throws UnsupportedEncodingException{
        // Get hash map in Set interface to get key and value
        Set<?> s = paramKeyValuePair.entrySet();

        // Move next key and value of HashMap by iterator
        Iterator<?> it = s.iterator();

        String urlWithParams = url;

        int count = 0;
        while(it.hasNext()){
            // key=value separator this by Map.Entry to get key and value
            Map.Entry<String, String> m = (Map.Entry<String, String>) it.next();

            if(m != null){
                // getKey is used to get key of HashMap
                String key = (String)m.getKey();

                // getValue is used to get value of key in HashMap
                String value=(String)m.getValue();

                if (count == 0){
                    urlWithParams = urlWithParams + "?" + key + "=" + URLEncoder.encode(value,"utf-8");
                }
                else{
                    urlWithParams = urlWithParams + "&" + key + "=" + URLEncoder.encode(value,"utf-8");
                }

                count++;
            }
        }

        HttpGet request = new HttpGet(urlWithParams);
        String result = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(request);
            if(response.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static String PostData(String url, String data){
        return "";
    }
}
package com.baymax.baymax.utils.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
    public static String GetPostData(HttpServletRequest request){

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }
        
        return jb.toString();
    }
    
    public static void writeResponse(HttpServletResponse response, int status, String info) throws IOException {
        response.setStatus(status);
        PrintWriter out = response.getWriter();
        out.println(info);
        out.close();
    }
}

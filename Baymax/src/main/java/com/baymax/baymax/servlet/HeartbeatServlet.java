package com.baymax.baymax.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.model.User;
import com.baymax.baymax.service.identity.UserService;

public class HeartbeatServlet extends BaseServlet{
    
    private final static Logger logger = LoggerFactory.getLogger(HeartbeatServlet.class);

    @Autowired
    private UserService userService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        /*
        User user = new User();
        user.setDeviceId("aaaaa");
        user.setName("Hao");

        userService.insertUser(user);
        */

        User user = userService.getUserByDeviceId("aaaaa");

        Gson gson = new Gson();
        String json = gson.toJson(user);

        logger.debug("json data: {}", json);

        resp.setStatus(200);
        writeResponse(resp, json);
    }

    private void writeResponse(HttpServletResponse response, String info) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(info);
    }
}

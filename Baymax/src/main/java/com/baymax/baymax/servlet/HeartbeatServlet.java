package com.baymax.baymax.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.model.User;
import com.baymax.baymax.service.identity.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/12/15
 * Time: 2:26 PM
 */
public class HeartbeatServlet extends BaseServlet{
    private final static Logger logger = LoggerFactory.getLogger(HeartbeatServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        // HttpSession session = req.getSession(true);
        ServletContext context = req.getServletContext();
        
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        
        UserService userService = (UserService)wac.getBean("userServiceImpl");

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

package com.baymax.baymax.servlet.identity;

import com.baymax.baymax.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/15/15
 * Time: 4:24 PM
 */
public class GetUserServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException {
        throw new ServletException("Error call for Get: "+ this.getClass().getName());
    }

}

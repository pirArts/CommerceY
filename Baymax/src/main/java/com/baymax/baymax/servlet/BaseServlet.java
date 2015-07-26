package com.baymax.baymax.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException {
        throw new ServletException("Error call for Get: "+ this.getClass().getName());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        throw new ServletException("Error call for Get: "+ this.getClass().getName());
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
    
    public void writeResponse(HttpServletResponse response, int status, String info) throws IOException {
        response.setStatus(status);
        PrintWriter out = response.getWriter();
        out.println(info);
        out.close();
    }
}

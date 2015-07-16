package com.baymax.baymax.servlet.commerce;

import com.baymax.baymax.servlet.BaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.model.Order;
import com.baymax.baymax.service.commerce.order.OrderService;

public class OrderServlet extends BaseServlet{

    private final static Logger logger = LoggerFactory.getLogger(OrderServlet.class);

    @Autowired
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        List<Order> orders = orderService.getOrderByUserEmail("yhao880514@hotmail.com");

        Gson gson = new Gson();
        String json = gson.toJson(orders);

        logger.debug(json);
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.close();
    }
}
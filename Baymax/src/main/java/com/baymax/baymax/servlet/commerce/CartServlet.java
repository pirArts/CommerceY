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

import com.baymax.baymax.model.Basket;
import com.baymax.baymax.service.commerce.cart.CartService;

public class CartServlet extends BaseServlet{

    private final static Logger logger = LoggerFactory.getLogger(CartServlet.class);

    @Autowired
    private CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        Basket basket = cartService.getBasketByUserEmail("yhao880514@hotmail.com");

        String json = "{}";
        if(basket != null){
            Gson gson = new Gson();
            json = gson.toJson(basket);
        }

        logger.debug(json);
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.close();
    }
}
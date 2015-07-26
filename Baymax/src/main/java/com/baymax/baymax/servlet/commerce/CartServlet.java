package com.baymax.baymax.servlet.commerce;

import com.baymax.baymax.servlet.BaseServlet;
import com.baymax.baymax.servlet.OperationResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.model.Basket;
import com.baymax.baymax.service.commerce.cart.CartService;
import com.baymax.baymax.utils.common.JsonUtil;
import com.baymax.baymax.utils.common.ServletUtil;

public class CartServlet extends BaseServlet{

    private final static Logger logger = LoggerFactory.getLogger(CartServlet.class);

    @Autowired
    private CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        Basket basket = cartService.getBasketByUserEmail("yhao880514@hotmail.com");

        String json = JsonUtil.Serialize(basket);
        logger.debug(json);
        
        ServletUtil.writeResponse(resp, 200, json);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postData = ServletUtil.GetPostData(req);
        Basket basket = (Basket)JsonUtil.DeSerialize(postData, Basket.class);
        
        OperationResult result = new OperationResult();
        if(basket != null){
            try{
                cartService.insertBasket(basket);
                result.setResult("Success");
            }
            catch(Exception e){
                result.setResult(e.getMessage());
            }
        }
        
        String json = JsonUtil.Serialize(result);
        logger.debug(json);
        
        ServletUtil.writeResponse(resp, 200, json);
    }
}
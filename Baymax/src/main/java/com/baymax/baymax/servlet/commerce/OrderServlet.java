package com.baymax.baymax.servlet.commerce;

import com.baymax.baymax.servlet.BaseServlet;
import com.baymax.baymax.servlet.OperationResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.model.Order;
import com.baymax.baymax.service.commerce.order.OrderService;
import com.baymax.baymax.utils.common.JsonUtil;
import com.baymax.baymax.utils.common.ServletUtil;

public class OrderServlet extends BaseServlet{

    private final static Logger logger = LoggerFactory.getLogger(OrderServlet.class);

    @Autowired
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        List<Order> orders = orderService.getOrderByUserEmail("yhao880514@hotmail.com");

        String json = JsonUtil.Serialize(orders);
        logger.debug(json);
        
        ServletUtil.writeResponse(resp, 200, json);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postData = ServletUtil.GetPostData(req);
        Order order = (Order)JsonUtil.DeSerialize(postData, Order.class);
        
        OperationResult result = new OperationResult();
        if(order != null){
            try{
                orderService.insertOrder(order);
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
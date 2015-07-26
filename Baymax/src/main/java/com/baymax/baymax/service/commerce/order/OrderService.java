package com.baymax.baymax.service.commerce.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baymax.baymax.model.Order;
import com.baymax.baymax.dao.OrderDAO;
import com.baymax.baymax.model.OrderItem;
import com.baymax.baymax.dao.OrderItemDAO;
import com.baymax.baymax.model.OrderState;
import com.baymax.baymax.dao.OrderStateDAO;
import com.baymax.baymax.model.PaymentType;
import com.baymax.baymax.dao.PaymentTypeDAO;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderItemDAO orderItemDAO;

    @Autowired
    private OrderStateDAO orderStateDAO;

    @Autowired
    private PaymentTypeDAO paymentTypeDAO;

    public List<Order> getOrderByUserEmail(String email)
    {
        return orderDAO.getOrderByUserEmail(email);
    }

    @Transactional
    public void insertOrder(Order order)
    {
        orderDAO.insertOrder(order);
        for(int i = 0; i < order.getOrderItems().size(); ++i){
            orderItemDAO.insertOrderItem(order.getOrderItems().get(i));
        }
    }

    @Transactional
    public void deleteOrder(Order order)
    {
        for(int i = 0; i < order.getOrderItems().size(); ++i){
            orderItemDAO.deleteOrderItem(order.getOrderItems().get(i));
        }
        orderDAO.deleteOrder(order);
    }

    public OrderItem getOrderItem(long orderItemId)
    {
        return orderItemDAO.getOrderItem(orderItemId);
    }

    public void insertOrderItem(OrderItem orderItem)
    {
        orderItemDAO.insertOrderItem(orderItem);
    }

    public void deleteOrderItem(OrderItem orderItem)
    {
        orderItemDAO.deleteOrderItem(orderItem);
    }

    public void deleteOrderItemsByOrder(OrderItem orderItem)
    {
        orderItemDAO.deleteOrderItemsByOrder(orderItem);
    }

    public OrderState getOrderState(long orderStateId)
    {
        return orderStateDAO.getOrderState(orderStateId);
    }

    public OrderState getOrderStateByName(String name)
    {
        return orderStateDAO.getOrderStateByName(name);
    }

    public void insertOrderState(OrderState orderState)
    {
        orderStateDAO.insertOrderState(orderState);
    }

    public void deleteOrderState(OrderState orderState)
    {
        orderStateDAO.deleteOrderState(orderState);
    }

    public PaymentType getPaymentType(long paymentTypeId)
    {
        return paymentTypeDAO.getPaymentType(paymentTypeId);
    }

    public PaymentType getPaymentTypeByName(String name)
    {
        return paymentTypeDAO.getPaymentTypeByName(name);
    }

    public void insertPaymentType(PaymentType paymentType)
    {
        paymentTypeDAO.insertPaymentType(paymentType);
    }

    public void deletePaymentType(PaymentType paymentType)
    {
        paymentTypeDAO.deletePaymentType(paymentType);
    }
}

package com.baymax.baymax.dao;

import com.baymax.baymax.model.OrderItem;

public interface OrderItemDAO{
    OrderItem getOrderItem(long orderItemId);

    void insertOrderItem(OrderItem orderItem);
    void deleteOrderItem(OrderItem orderItem);
    void deleteOrderItemsByOrder(OrderItem orderItem);
}
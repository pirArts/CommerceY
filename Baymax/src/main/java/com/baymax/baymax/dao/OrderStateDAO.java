package com.baymax.baymax.dao;

import com.baymax.baymax.model.OrderState;

public interface OrderStateDAO{
    OrderState getOrderState(long orderStateId);
    OrderState getOrderStateByName(String name);

    void insertOrderState(OrderState orderState);
    void deleteOrderState(OrderState orderState);
}
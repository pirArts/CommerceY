package com.baymax.baymax.dao;

import java.util.List;

import com.baymax.baymax.model.Order;

public interface OrderDAO{
    List<Order> getOrderByUserEmail(String email);
}
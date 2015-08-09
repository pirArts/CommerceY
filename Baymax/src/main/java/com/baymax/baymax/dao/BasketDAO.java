package com.baymax.baymax.dao;

import com.baymax.baymax.model.Basket;

public interface BasketDAO{
    Basket getBasketByUserEmail(String email);

    void insertBasket(Basket basket);
    void deleteBasket(Basket basket);
}
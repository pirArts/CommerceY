package com.baymax.baymax.dao;

import com.baymax.baymax.model.BasketItem;

public interface BasketItemDAO{
    BasketItem getBasketItem(long basketItemId);
    
    void insertBasketItem(BasketItem basketItem);
    void deleteBasketItem(BasketItem basketItem);
    void deleteBasketItemsByBasket(BasketItem basketItem);
}
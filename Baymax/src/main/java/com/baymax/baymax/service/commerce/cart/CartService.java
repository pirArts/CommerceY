package com.baymax.baymax.service.commerce.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baymax.baymax.model.Basket;
import com.baymax.baymax.dao.BasketDAO;

import com.baymax.baymax.model.BasketItem;
import com.baymax.baymax.dao.BasketItemDAO;

@Service
public class CartService {

    @Autowired
    private BasketDAO basketDAO;

    @Autowired
    private BasketItemDAO basketItemDAO;

    public Basket getBasketByUserEmail(String email)
    {
        return basketDAO.getBasketByUserEmail(email);
    }

    public void insertBasket(Basket basket)
    {
        basketDAO.insertBasket(basket);
    }

    public void deleteBasket(Basket basket)
    {
        basketDAO.deleteBasket(basket);
    }

    public BasketItem getBasketItem(long basketItemId)
    {
        return basketItemDAO.getBasketItem(basketItemId);
    }

    public void insertBasketItem(BasketItem basketItem)
    {
        basketItemDAO.insertBasketItem(basketItem);
    }

    public void deleteBasketItem(BasketItem basketItem)
    {
        basketItemDAO.deleteBasketItem(basketItem);
    }

    public void deleteBasketItemsByBasket(BasketItem basketItem)
    {
        basketItemDAO.deleteBasketItemsByBasket(basketItem);
    }
}

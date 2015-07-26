package com.baymax.baymax.service.commerce.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void insertBasket(Basket basket)
    {
        basketDAO.insertBasket(basket);
        for(int i = 0; i < basket.getBasketItems().size(); ++i){
            basketItemDAO.insertBasketItem(basket.getBasketItems().get(i));
        }
    }

    @Transactional
    public void deleteBasket(Basket basket)
    {
        for(int i = 0; i < basket.getBasketItems().size(); ++i){
            basketItemDAO.deleteBasketItem(basket.getBasketItems().get(i));
        }
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

package com.baymax.baymax.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Basket{
    private long id;
    private float amount;
    private Date createTime;
    private List<BasketItem> basketItems = new ArrayList<BasketItem>();
    private Customer customer;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public List<BasketItem> getBasketItems() {
        return basketItems;
    }
    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
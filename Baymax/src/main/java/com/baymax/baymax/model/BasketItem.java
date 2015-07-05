package com.baymax.baymax.model;

public class BasketItem{
    private long id;
    private Basket basket;
    private Product product;
    private int quantity;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Basket getBasket() {
        return basket;
    }
    public void setBasket(Basket basket) {
        this.basket = basket;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
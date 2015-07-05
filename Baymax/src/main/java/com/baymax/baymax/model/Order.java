package com.baymax.baymax.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order{
	private long id;
	private float amount;
	private Date createTime;
	private OrderState orderState;
	private Customer customer;
	private Date paymentTime;
	private int paymentResult;
	private PaymentType paymentType;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
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
	public OrderState getOrderState() {
		return orderState;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public int getPaymentResult() {
		return paymentResult;
	}
	public void setPaymentResult(int paymentResult) {
		this.paymentResult = paymentResult;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
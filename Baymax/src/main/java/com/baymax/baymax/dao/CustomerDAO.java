package com.baymax.baymax.dao;

import com.baymax.baymax.model.Customer;

public interface CustomerDAO{
    Customer getCustomerByEmail(String email);

    void insertCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    void deleteCustomersByType(Customer customer);
}
package com.baymax.baymax.dao;

import java.util.List;

import com.baymax.baymax.model.CustomerType;

public interface CustomerTypeDAO {
    List<CustomerType> getCustomerTypeList();
    CustomerType getCustomerType(long typeId);
    CustomerType getCustomerTypeByName(String name);

    void insertCustomerType(CustomerType customerType);
    void deleteCustomerType(CustomerType customerType);
}
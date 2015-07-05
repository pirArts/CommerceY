package com.baymax.baymax.service.identity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baymax.baymax.dao.CustomerTypeDAO;
import com.baymax.baymax.model.CustomerType;

import com.baymax.baymax.dao.CustomerDAO;
import com.baymax.baymax.model.Customer;

@Service
public class CustomerService{
 
    @Autowired
    private CustomerTypeDAO customerTypeDAO;

    @Autowired
    private CustomerDAO customerDAO;
    
    public List<CustomerType> getCustomerTypeList()
    {
        return customerTypeDAO.getCustomerTypeList();
    }
    
    public CustomerType getCustomerType(long typeId)
    {
        return customerTypeDAO.getCustomerType(typeId);
    }

    public CustomerType getCustomerTypeByName(String name)
    {
        return customerTypeDAO.getCustomerTypeByName(name);
    }

    public void insertCustomerType(CustomerType customerType)
    {
        customerTypeDAO.insertCustomerType(customerType);
    }

    public void deleteCustomerType(CustomerType customerType)
    {
        customerTypeDAO.deleteCustomerType(customerType);
    }

    public Customer getCustomerByEmail(String email)
    {
        return customerDAO.getCustomerByEmail(email);
    }

    public void insertCustomer(Customer customer)
    {
        customerDAO.insertCustomer(customer);
    }

    public void deleteCustomer(Customer customer)
    {
        customerDAO.deleteCustomer(customer);
    }

    public void deleteCustomersByType(Customer customer)
    {
        customerDAO.deleteCustomersByType(customer);
    }
}
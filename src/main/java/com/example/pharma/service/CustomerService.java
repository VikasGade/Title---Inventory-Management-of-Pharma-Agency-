package com.example.pharma.service;

import com.example.pharma.entity.CustomerData;

import java.util.List;

public interface CustomerService {

    CustomerData saveNewCustomer(CustomerData customerData);

    List<CustomerData> showAll();
}

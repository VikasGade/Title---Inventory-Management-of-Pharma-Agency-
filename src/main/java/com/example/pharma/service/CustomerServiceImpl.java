package com.example.pharma.service;

import com.example.pharma.entity.CustomerData;
import com.example.pharma.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired private CustomerRepository customerRepository;

    @Override
    public CustomerData saveNewCustomer(CustomerData customerData) {
        return customerRepository.save(customerData);
    }

    @Override
    public List<CustomerData> showAll() {
        return customerRepository.findAll();
    }
}


package com.example.pharma.controller;

import com.example.pharma.entity.CustomerData;
import com.example.pharma.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RegisterCustomer")
public class CustomerController {
    @Autowired private CustomerService customerService;
    @PostMapping("savecustomer")
    public CustomerData saveCustomer(@RequestBody CustomerData customerData){
        return customerService.saveNewCustomer(customerData);
    }

    @GetMapping("/showcustomer")
    public List<CustomerData> showCustomer(){
        return customerService.showAll();
    }
}

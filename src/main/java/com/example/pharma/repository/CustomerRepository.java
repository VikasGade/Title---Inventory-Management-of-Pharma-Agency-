package com.example.pharma.repository;

import com.example.pharma.entity.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerData,Long> {
    CustomerData findByCustomerName(String customerName);
}

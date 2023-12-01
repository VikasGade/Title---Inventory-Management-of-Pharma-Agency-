package com.example.pharma.service;

import com.example.pharma.controller.DailySales;
import com.example.pharma.entity.DailySalesData;
import com.example.pharma.entity.PharmaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailySalesService  {


    DailySalesData dailySalePrescribed(/*DailySalesData dailySalesProduct,*/
                             String doctorName,
                             String custName,
                             String productName);

    DailySalesData dailySaleGeneric(String custName, String productName);
}

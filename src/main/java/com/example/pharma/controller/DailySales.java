package com.example.pharma.controller;

import com.example.pharma.entity.CustomerData;
import com.example.pharma.entity.DailySalesData;
import com.example.pharma.entity.DoctorData;
import com.example.pharma.entity.PharmaProduct;
import com.example.pharma.service.DailySalesService;
import com.example.pharma.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DailySales {
    @Autowired
    private DailySalesService dailySalesService;


//    @PostMapping("/saleProduct/{prdtName}")
//    PharmaProduct saleProduct(@RequestBody CustomerData customerData,
//                              @RequestBody DoctorData doctorData,
//                              @PathVariable("prdtName") String productName){
//        return productService.saledProduct(customerData,doctorData,productName);
//    }

    @GetMapping("/dailysaleProduct/prdtName/{prdtName}/custName/{custName}/drName/{drName}")
    DailySalesData saleProductPrescribed(/*@RequestBody DailySalesData dailySalesProduct,*/
            @PathVariable("drName") String doctorName,
            @PathVariable("custName") String custName,
            @PathVariable("prdtName") String productName) {
        return dailySalesService.dailySalePrescribed(/*dailySalesProduct,*/doctorName, custName, productName);
    }

    @GetMapping("/dailysaleProduct/prdtName/{prdtName}/custName/{custName}")
    DailySalesData saleProductGeneric(/*@RequestBody DailySalesData dailySalesProduct,*/
            @PathVariable("custName") String custName,
            @PathVariable("prdtName") String productName) {
        return dailySalesService.dailySaleGeneric( custName, productName);
    }

}

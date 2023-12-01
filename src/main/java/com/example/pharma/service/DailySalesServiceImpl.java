package com.example.pharma.service;

import com.example.pharma.entity.CustomerData;
import com.example.pharma.entity.DailySalesData;
import com.example.pharma.entity.DoctorData;
import com.example.pharma.entity.PharmaProduct;
import com.example.pharma.exception.EnterValidProduct;
import com.example.pharma.exception.ResourceNotFoundException;
import com.example.pharma.repository.CustomerRepository;
import com.example.pharma.repository.DailySalesRepository;
import com.example.pharma.repository.DoctorRepository;
import com.example.pharma.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DailySalesServiceImpl implements DailySalesService {
    @Autowired
    private DailySalesRepository dailySalesRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DailySalesData dailySalePrescribed(/*DailySalesData dailySalesProduct,*/
            String doctorName, String custName, String productName) {
        System.out.println("inside method");
        DailySalesData dailySalesProduct = new DailySalesData();

        PharmaProduct dBPharmaProduct = productRepository.findByProductName(productName);
        String dbProductName = dBPharmaProduct.getProductName();
        System.out.println(dBPharmaProduct);

        DoctorData dbDoctorData = doctorRepository.findByDoctorName(doctorName);
        String dbDoctorName = dbDoctorData.getDoctorName();
        System.out.println(dbDoctorName);

        CustomerData dBcustomerData = customerRepository.findByCustomerName(custName);
        String dBCustomerName = dBcustomerData.getCustomerName();
        System.out.println(dBCustomerName);
//
//        if (!(dbProductName.equals(productName))) {
//            throw new ResourceNotFoundException("product not found with name " + productName);
//        } else if (!(dbDoctorName.equals(doctorName))) {
//            throw new ResourceNotFoundException("user not found with name " + doctorName);
//        } else if (!(dBCustomerName.equals(custName))) {
//            throw new ResourceNotFoundException("user not found with name " + custName);
//        }
//        productName.toLowerCase();
        String productCata = dBPharmaProduct.getProductCategory();
        System.out.println(productCata);
        //DailySalesData product = null;
        if (dbProductName.equalsIgnoreCase(productName) && productCata.equals("prescribed") && dBCustomerName.equalsIgnoreCase(custName) && doctorName.equalsIgnoreCase(dbDoctorName)) {

            System.out.println("inside 3rd loop");
            dailySalesProduct.setDoctor(dbDoctorData);
            dailySalesProduct.setCustomer(dBcustomerData);

            dailySalesProduct.setProductId(dBPharmaProduct.getProductId());
            dailySalesProduct.setProductName(dBPharmaProduct.getProductName());
            dailySalesProduct.setProductCategory(dBPharmaProduct.getProductCategory());
            dailySalesProduct.setProductDescription(dBPharmaProduct.getProductDescription());
            dailySalesProduct.setProductPrice(dBPharmaProduct.getProductPrice());
            dailySalesProduct.setProductQuantity(dBPharmaProduct.getProductQuantity());
            dailySalesProduct.setMgfDate(dBPharmaProduct.getMgfDate());
            dailySalesProduct.setExpDate(dBPharmaProduct.getExpDate());
            return dailySalesRepository.save(dailySalesProduct);
        } else if (!(productCata.equals("prescribed"))) {
            throw new EnterValidProduct("Enter Prescribed products only");
        }

        return dailySalesProduct;
    }
//for daily product selling for generic product only
    @Override
    public DailySalesData dailySaleGeneric(String custName, String productName) {
        DailySalesData dailySalesProduct = new DailySalesData();
        System.out.println("Generic.......");
        PharmaProduct dBPharmaProduct = productRepository.findByProductName(productName);
        String dbProductName = dBPharmaProduct.getProductName();

        CustomerData dBcustomerData = customerRepository.findByCustomerName(custName);
        String dBCustomerName = dBcustomerData.getCustomerName();
        String productCata = dBPharmaProduct.getProductCategory();
        /*if (!(dbProductName.equals(productName))) {
            throw new ResourceNotFoundException("product not found with name " + productName);
        } else if (!(dBCustomerName.equals(custName))) {
            throw new ResourceNotFoundException("user not found with name " + custName);
        }  */
        if (dbProductName.equalsIgnoreCase(productName) && !(productCata.equals("prescribed")) && dBCustomerName.equalsIgnoreCase(custName)) {
            //dailySalesProduct.setDoctor(null);
            dailySalesProduct.setCustomer(dBcustomerData);

            dailySalesProduct.setProductId(dBPharmaProduct.getProductId());
            dailySalesProduct.setProductName(dBPharmaProduct.getProductName());
            dailySalesProduct.setProductCategory(dBPharmaProduct.getProductCategory());
            dailySalesProduct.setProductDescription(dBPharmaProduct.getProductDescription());
            dailySalesProduct.setProductPrice(dBPharmaProduct.getProductPrice());
            dailySalesProduct.setProductQuantity(dBPharmaProduct.getProductQuantity());
            dailySalesProduct.setMgfDate(dBPharmaProduct.getMgfDate());
            dailySalesProduct.setExpDate(dBPharmaProduct.getExpDate());
            return dailySalesRepository.save(dailySalesProduct);

        } else if ((productCata.equals("prescribed"))) {
            throw new EnterValidProduct("Enter product in Prescribed products list");

        }
        System.out.println(dailySalesProduct);
        return dailySalesProduct;
    }
}

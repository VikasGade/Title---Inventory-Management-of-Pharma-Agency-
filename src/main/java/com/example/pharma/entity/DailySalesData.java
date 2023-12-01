package com.example.pharma.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DailySalesData {
    @Id
    private Long productId;
    @Column(name = "Name", length = 10, nullable = false)
    private String productName;

    @Column(name = "Description", length = 100, nullable = false)
    private String productDescription;

    @Column(name = "Category")
    private String productCategory;
    //general or prescribed

    @Column(name = "Price", nullable = false)
    private Integer productPrice;

    @Column(name = "Quantity", nullable = false)
    private Integer productQuantity;

    //import date from java.sql.Date instead of java.util.Date
    @Column(name = "Manufactured Date")
    private Date mgfDate;

    @Column(name = "Expiration Date")
    private Date expDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerData customer;

    @ManyToOne(cascade = CascadeType.ALL)
    private DoctorData doctor;
}

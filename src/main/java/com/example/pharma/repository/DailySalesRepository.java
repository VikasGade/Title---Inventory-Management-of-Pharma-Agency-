package com.example.pharma.repository;


import com.example.pharma.entity.DailySalesData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailySalesRepository extends JpaRepository<DailySalesData,Long> {
}

package com.example.pharma.repository;

import com.example.pharma.entity.CustomerData;
import com.example.pharma.entity.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorData,Long> {
    DoctorData findByDoctorName(String uiDoctorName);
}

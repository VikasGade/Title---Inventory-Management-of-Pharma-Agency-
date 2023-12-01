package com.example.pharma.service;

import com.example.pharma.entity.DoctorData;

import java.util.List;

public interface DoctorService {
    DoctorData saveNewDoctor(DoctorData doctorData);

    List<DoctorData> showAll();
}

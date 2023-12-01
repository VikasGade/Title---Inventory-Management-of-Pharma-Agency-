package com.example.pharma.service;

import com.example.pharma.entity.DoctorData;
import com.example.pharma.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired private DoctorRepository doctorRepository;

    @Override
    public DoctorData saveNewDoctor(DoctorData doctorData) {
        return doctorRepository.save(doctorData);
    }

    @Override
    public List<DoctorData> showAll() {
        return doctorRepository.findAll();
    }
}

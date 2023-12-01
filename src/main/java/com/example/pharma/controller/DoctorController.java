package com.example.pharma.controller;

import com.example.pharma.entity.CustomerData;
import com.example.pharma.entity.DoctorData;
import com.example.pharma.service.CustomerService;
import com.example.pharma.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RegisterDoctor")
public class DoctorController {
    @Autowired private DoctorService doctorService;

    @PostMapping("savedoctor")
    public DoctorData saveDoctor(@RequestBody DoctorData doctorData){
        return doctorService.saveNewDoctor(doctorData);
    }

    @GetMapping("/showdoctor")
    public List<DoctorData> showDoctor(){
        return doctorService.showAll();
    }

}

package com.example.ec_test.controller;

import com.example.ec_test.entitie.Business;
import com.example.ec_test.repository.BusinessRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
@AllArgsConstructor
public class BusinessController {
    private BusinessRepository businessRepository;

    @GetMapping
    public List<Business> list_business(){return businessRepository.findAll();};
}

package com.example.ec_test.controller;

import com.example.ec_test.entitie.Employee;
import com.example.ec_test.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    /**
     * Obtiene listado de las listas de empleados por empresa.
     * @return List
     */
    @GetMapping
    public List<Employee> list_employee(){return employeeRepository.findAll();}
}

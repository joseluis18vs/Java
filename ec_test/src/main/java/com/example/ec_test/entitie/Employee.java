package com.example.ec_test.entitie;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String employee_name;

    String employee_code;

}

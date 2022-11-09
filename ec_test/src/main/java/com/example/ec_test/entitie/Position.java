package com.example.ec_test.entitie;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="Position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position_name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "position_employee",
            joinColumns = {
                    @JoinColumn(name = "POSITION_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "EMPLOYEE_ID") })
    private Set<Employee> employees;

}

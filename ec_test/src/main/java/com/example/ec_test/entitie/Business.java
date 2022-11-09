package com.example.ec_test.entitie;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Table(name="Business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String business_name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "business_positions",
            joinColumns = {
                    @JoinColumn(name = "BUSINESS_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "POSITION_ID") })
    private Set<Position> position;

}

package com.example.ec_test.repository;

import com.example.ec_test.entitie.Employee;
import com.example.ec_test.entitie.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}

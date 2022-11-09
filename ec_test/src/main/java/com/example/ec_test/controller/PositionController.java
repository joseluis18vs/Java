package com.example.ec_test.controller;


import com.example.ec_test.entitie.Position;
import com.example.ec_test.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/positions")
@AllArgsConstructor
public class PositionController {
    private final PositionRepository positionRepository;

    /**
     * Obtiene listado de las listas de posiciones por empresa.
     * @return List
     */
    @GetMapping
    public List<Position> list_employee(){return positionRepository.findAll();}
}

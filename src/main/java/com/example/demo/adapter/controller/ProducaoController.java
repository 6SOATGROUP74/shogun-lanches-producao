package com.example.demo.adapter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducaoController {

    @PostMapping
    public ResponseEntity<?> teste(){

        return ResponseEntity.status(HttpStatus.CREATED).body("TESTEEEEEEEEE");
    }

}

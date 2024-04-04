package com.example.api_tester.controller;

import com.example.api_tester.model.Pais;
import com.example.api_tester.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity create(@RequestBody Pais entity){
        repository.save(entity);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/paises-replica", entity, String.class);

        System.out.println(responseEntity.getStatusCode());
        return ResponseEntity.ok().body(entity);

    }

//    @GetMapping
//    public ResponseEntity findAll(){
//
//    }
}

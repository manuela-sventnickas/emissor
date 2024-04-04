package com.example.api_tester.repository;

import com.example.api_tester.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}

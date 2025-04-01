package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Company;
@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
    
}

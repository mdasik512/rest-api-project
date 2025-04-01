package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    @Modifying
    @Query("SELECT a FROM Admin a")
    List<Admin> findAdmin();

}

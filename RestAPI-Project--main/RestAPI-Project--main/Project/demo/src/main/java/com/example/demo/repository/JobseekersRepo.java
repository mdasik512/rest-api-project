package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Jobseekers;

@Repository
public interface JobseekersRepo extends JpaRepository<Jobseekers, Long> {
@Query("SELECT js FROM Jobseekers js JOIN js.jobs j WHERE j.id = :jobId")
    List<Jobseekers> findJobseekersByJobId(@Param("jobId") Long jobId);
    
}

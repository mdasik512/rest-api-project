package com.example.demo.repository;

import java.util.List;

// import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Jobs;

@Repository
public interface JobRepo extends JpaRepository<Jobs, Long> {
@Query("SELECT j FROM Jobs j JOIN j.jobseekers js WHERE js.id = :jobseekerId")
    List<Jobs> findJobsByJobseekerId(@Param("jobseekerId") Long jobseekerId);
    
}
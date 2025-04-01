package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.Jobs;
import com.example.demo.models.Jobseekers;
// import com.example.demo.models.Jobseekers;
import com.example.demo.repository.JobRepo;
import com.example.demo.repository.JobseekersRepo;

@Service
public class JobService {
    @Autowired
JobRepo jobRepo;
JobseekersRepo jobseekersRepo;
    public Jobs addJobService(Jobs job)
    {
        return jobRepo.save(job);
    }
    public List<Jobs>getAllJobs()
    {
        return jobRepo.findAll();
    }
    public Jobs updateJob(long id,Jobs job)
    {
            return null;

    }
    public void deleteJob(long id)
    {
        jobRepo.deleteById(id);
    }
    public Page<Jobs>getPage(int page,int size)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable=PageRequest.of(page, size,sort);
        return jobRepo.findAll(pageable);
    }
     public List<Jobs> getJobsByJobseeker(Long jobseekerId) {
        return jobRepo.findJobsByJobseekerId(jobseekerId);
    }

    // Add a Jobseeker to a Job
    public Jobs addJobseekerToJob(Long jobId, Long jobseekerId) {
        Jobs job = jobRepo.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
        Jobseekers jobseeker = jobseekersRepo.findById(jobseekerId).orElseThrow(() -> new RuntimeException("Jobseeker not found"));

        job.getJobseekers().add(jobseeker);
        return jobRepo.save(job);
    }
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Jobs;
// import com.example.demo.models.Jobseekers;
import com.example.demo.service.JobService;
// import com.example.demo.service.JobseekersService;

@RestController
@RequestMapping("/Job")
public class JobController {
    @Autowired
    JobService JobService;
    @PostMapping("/postJob")
    public ResponseEntity<Jobs> addJobseeker(@RequestBody Jobs jobs )
    {
        return new ResponseEntity<>(JobService.addJobService(jobs),HttpStatus.CREATED);
    }
    @GetMapping("/getJob")
    public ResponseEntity<List<Jobs>>getJobseekers()
    {
        return new ResponseEntity<>(JobService.getAllJobs(),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Jobs>updateJobseekers(@PathVariable long id,@RequestBody Jobs Jobs)
    {
        
        return new ResponseEntity<>(JobService.updateJob(id,Jobs),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object>deleteJobseeker(@PathVariable long id)
    {
        return ResponseEntity.ok("Deleted");
    }
    @GetMapping("/paginate1")
    public Page<Jobs> paginate1(@RequestParam int page,@RequestParam int size)
    {
        
        return JobService.getPage(page,size);
    }
     // Find Jobs by Jobseeker ID
     @GetMapping("/jobseekers/{jobseekerId}")
     public ResponseEntity<List<Jobs>> getJobsByJobseeker(@PathVariable Long jobseekerId) {
         return new ResponseEntity<>(JobService.getJobsByJobseeker(jobseekerId), HttpStatus.OK);
     }
 
     // Add a Jobseeker to a Job
     @PostMapping("/{jobId}/jobseekers/{jobseekerId}")
     public ResponseEntity<Jobs> addJobseekerToJob(@PathVariable Long jobId, @PathVariable Long jobseekerId) {
         Jobs job = JobService.addJobseekerToJob(jobId, jobseekerId);
         return new ResponseEntity<>(job, HttpStatus.OK);
     }
    
    
}


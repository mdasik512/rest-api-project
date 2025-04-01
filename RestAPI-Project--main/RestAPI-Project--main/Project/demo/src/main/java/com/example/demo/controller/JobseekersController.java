package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Jobseekers;
import com.example.demo.service.JobseekersService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/Jobseeker")
public class JobseekersController {
    @Autowired
    JobseekersService jobseekers;
    @PostMapping("/postJobseeker")
    public ResponseEntity<Jobseekers> addJobseeker(@RequestBody Jobseekers jobseek )
    {
        return new ResponseEntity<>(jobseekers.addJobseeker(jobseek),HttpStatus.CREATED);
    }
    @GetMapping("/getJobseeker")
    public ResponseEntity<List<Jobseekers>>getJobseekers()
    {
        return new ResponseEntity<>(jobseekers.getAllJobseekers(),HttpStatus.OK);
    }
    @GetMapping("/getJobseeker/{id}")
    public ResponseEntity<List<Jobseekers>> getById(@PathVariable long id) {
        return new ResponseEntity<>(jobseekers.getbyId(id),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Jobseekers>updateJobseekers(@PathVariable long id,@RequestBody Jobseekers jobseek)
    {
        
        return new ResponseEntity<>(jobseekers.updateJobseekers(id,jobseek),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object>deleteJobseeker(@PathVariable long id)
    {
        return ResponseEntity.ok("Deleted");
    }
    @GetMapping("/paginate1")
    public Page<Jobseekers> paginate1(@RequestParam int page,@RequestParam int size)
    {
        
        return jobseekers.getPage(page,size);
    }
    
    
}

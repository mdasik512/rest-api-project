package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/Company")

public class CompanyController {
    @Autowired
    CompanyService companyService;
    @PostMapping("/post")
    public ResponseEntity<Object>addCompany(@RequestBody Company company)
    {
        companyService.addCompany(company);
        return new ResponseEntity<> ("Company Data added",HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Company>>getCompany()
    {
        return new ResponseEntity<>(companyService.getallCompany(),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object>updateCompany(@PathVariable long id,@RequestBody Company company )
    {
        companyService.updateCompany(id, company);
        return new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object>deleteCompany(@PathVariable long id)
    {
        companyService.deleteCompany(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
    
    
    
}

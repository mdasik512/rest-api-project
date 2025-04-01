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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Admin;
import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/postAdmin")
    public ResponseEntity<Object> addAdmin(@RequestBody Admin admin)
    {
        adminService.addAdmin(admin);
        return new ResponseEntity<>("Admin Data added",HttpStatus.CREATED);
    }

    @GetMapping("/getAdmin")
    public ResponseEntity<List<Admin>> getAdmins()
    {
        return new ResponseEntity<>(adminService.getAllAdmins(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAdmin(@PathVariable long id,@RequestBody Admin admin)
    {
        adminService.updateAdmin(id, admin);
        return new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable long id)
    {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }

    @GetMapping("/paginate")
    public Page<Admin> getPage(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size)
    {
        return adminService.getPage(page,size);
    }

}

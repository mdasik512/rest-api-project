package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.Admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;
     //post
    public void addAdmin(Admin admin)
    {
        adminRepo.save(admin);
    }
    //get
    public List<Admin> getAllAdmins()
    {
        return adminRepo.findAdmin();
    }
  //put or update
    public Admin updateAdmin(long id,Admin admin)
    {
        Optional<Admin> adminExists=adminRepo.findById(id);
        if(adminExists.isPresent())
        {
           Admin newAdmin=adminExists.get();
           if(admin.getName()!=null)
           {
               newAdmin.setName(admin.getName());
           }
           if(admin.getEmail()!=null)
           {
            newAdmin.setEmail(admin.getEmail());
           }

           return adminRepo.save(newAdmin);
        }
        else{
            return null;
        }
    }

    public void deleteAdmin(long id)
    {
        adminRepo.deleteById(id);
    }

    public Page<Admin> getPage(int page,int size)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable=PageRequest.of(page, size,sort);
        return adminRepo.findAll(pageable);
    }
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.demo.models.Admin;
import com.example.demo.models.Company;
import com.example.demo.repository.CompanyRepo;

@Service
public class CompanyService {
    @Autowired
    CompanyRepo companyRepo;
    public void addCompany(Company company)
    {
       companyRepo.save(company);

    }
    public List<Company>getallCompany()
    {
        return companyRepo.findAll();
    }
    public Company updateCompany(long id,Company company)
    {
        Optional<Company> companyExists=companyRepo.findById(id);
        if(companyExists.isPresent())
        {
           Company newCompany=companyExists.get();
           if(company.getName()!=null)
           {
               newCompany.setName(company.getName());
           }
           if(company.getLocation()!=null)
           {
            newCompany.setLocation(company.getLocation());
           }
           if(company.getIndustry()!=null)
           {
            newCompany.setIndustry(company.getIndustry());
           }
           if(company.getDescription()!=null)
           {
            newCompany.setDescription(company.getDescription());
           }

           return companyRepo.save(newCompany);
        }
        else{
            return null;
        }
    }
        public void deleteCompany(long id)
        {
            companyRepo.deleteById(id);
        }
    


}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.Jobseekers;
import com.example.demo.repository.JobseekersRepo;

@Service
public class JobseekersService {

    @Autowired
    JobseekersRepo jobseekersRepo;

    public Jobseekers addJobseeker(Jobseekers jobseekers)
    {
       return jobseekersRepo.save(jobseekers);
    }
    public List<Jobseekers> getAllJobseekers()
    {
        return jobseekersRepo.findAll();
    }
    public List<Jobseekers> getbyId(long id)
    {
        return jobseekersRepo.findJobseekersByJobId(id);
    }
    public Jobseekers updateJobseekers(long id,Jobseekers jobseekers)
    {
        Optional<Jobseekers> jobseekersExists=jobseekersRepo.findById(id);
        if(jobseekersExists.isPresent())
        {
            Jobseekers newJobseekers=jobseekersExists.get();
            if(jobseekers.getName()!=null)
            {
                newJobseekers.setName(jobseekers.getName());
            }
            if(jobseekers.getEmail()!=null)
            {
                newJobseekers.setEmail(jobseekers.getEmail());
            }
            if(jobseekers.getNum()!=0)
            {
                newJobseekers.setNum(jobseekers.getNum());
            }
            if(jobseekers.getResumeurl()!=null)
            {
                newJobseekers.setResumeurl(jobseekers.getResumeurl());
            }
            if(jobseekers.getSkill()!=null)
            {
                newJobseekers.setSkill(jobseekers.getSkill());
            }
            return jobseekersRepo.save(newJobseekers);
        }
        else{
            return null;
        }
    } 
    public void deleteJobseeker(long id)
    {
        jobseekersRepo.deleteById(id);
    }
    public Page<Jobseekers>getPage(int page,int size)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable=PageRequest.of(page, size,sort);
        return jobseekersRepo.findAll(pageable);
    }

}


package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="jobseekers")
public class Jobseekers {
    @Id
    long id;
    String name;
    String email;
    long num;
    String resumeurl;
    String skill[];
    @ManyToMany(mappedBy = "jobseekers")
     private Set<Jobs> jobs = new HashSet<>();
    public Jobseekers() {
    }
    public Jobseekers(long id, String name, String email, long num, String resumeurl, String[] skill) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.num = num;
        this.resumeurl = resumeurl;
        this.skill = skill;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getNum() {
        return num;
    }
    public void setNum(long num) {
        this.num = num;
    }
    public String getResumeurl() {
        return resumeurl;
    }
    public void setResumeurl(String resumeurl) {
        this.resumeurl = resumeurl;
    }
    public String[] getSkill() {
        return skill;
    }
    public void setSkill(String[] skill) {
        this.skill = skill;
    }
    public Set<Jobs> getJobs() {
        return jobs;
    }
    public void setJobs(Set<Jobs> jobs) {
        this.jobs = jobs;
    }

}

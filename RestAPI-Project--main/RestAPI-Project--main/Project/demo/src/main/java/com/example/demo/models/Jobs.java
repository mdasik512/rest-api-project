package com.example.demo.models;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jobs")
public class Jobs {
    @Id
    long id;
    String title;
    String company;
    String location;
    String description;
    long salary;
    
    @ManyToMany
    @JoinTable(
        name="job_applications",
        joinColumns = @JoinColumn(name ="job_id"),
        inverseJoinColumns = @JoinColumn(name = "jobseeker_id")
    )
    
    private Set<Jobseekers>jobseekers =new HashSet<>();
     @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true)
    Admin admin;
    public Jobs() {
    }
    public Jobs(long id, String title, String company, String location, String description, long salary ,Admin admin) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.salary = salary;
        this.admin = admin;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public Set<Jobseekers> getJobseekers() {
        return jobseekers;
    }
    public void setJobseekers(Set<Jobseekers> jobseekers) {
        this.jobseekers = jobseekers;

    }
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}

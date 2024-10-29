package com.loki.springboot.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class JobController {
    private List<Job> jobs;
    public JobController(){
        this.jobs = new ArrayList<>();
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return this.jobs;
    }
    @PostMapping("/jobs/create")
    public String createJob(@RequestBody Job job){
        this.jobs.add(job);
        return "Job added successfully";

    }
}

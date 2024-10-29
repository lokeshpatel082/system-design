package com.loki.springboot.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return this.jobService.findAll();
    }
    @PostMapping("/jobs/create")
    public String createJob(@RequestBody Job job){
        this.jobService.createJob(job);
        return "Job added successfully";

    }
}

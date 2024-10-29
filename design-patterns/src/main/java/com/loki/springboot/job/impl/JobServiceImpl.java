package com.loki.springboot.job.impl;

import com.loki.springboot.job.Job;
import com.loki.springboot.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return this.jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        this.jobs.add(job);
    }
}

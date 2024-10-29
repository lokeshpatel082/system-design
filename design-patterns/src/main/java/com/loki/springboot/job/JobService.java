package com.loki.springboot.job;

import java.util.List;

public interface JobService {
    public List<Job> findAll();
    public void createJob(Job job);
}

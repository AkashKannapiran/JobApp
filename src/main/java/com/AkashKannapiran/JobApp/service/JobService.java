package com.AkashKannapiran.JobApp.service;

import com.AkashKannapiran.JobApp.model.JobPost;
import com.AkashKannapiran.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public void addJob(JobPost job) {
        jobRepo.addJob(job);
    }

    public JobPost getJob(int postID) {
        return jobRepo.getJob(postID);
    }

    public void updateJob(JobPost job) {
        jobRepo.updateJob(job);
    }

    public void deleteJob(int postID) {
        jobRepo.deleteJob(postID);
    }
}

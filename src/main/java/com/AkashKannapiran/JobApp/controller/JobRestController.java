package com.AkashKannapiran.JobApp.controller;

import com.AkashKannapiran.JobApp.model.JobPost;
import com.AkashKannapiran.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/job")
    public JobPost addJob(@RequestBody JobPost job) {
        jobService.addJob(job);
        return jobService.getJob(job.getPostID());
    }

    @GetMapping("/job/{postID}")
    public JobPost getJob(@PathVariable("postID") int postID) {
        return jobService.getJob(postID);
    }

    @PutMapping("/job")
    public JobPost updateJob(@RequestBody JobPost job) {
        jobService.updateJob(job);
        return jobService.getJob(job.getPostID());
    }

    @DeleteMapping("/job/{postID}")
    public String deleteJob(@PathVariable int postID) {
        jobService.deleteJob(postID);
        return "Job deleted successfully";
    }
}

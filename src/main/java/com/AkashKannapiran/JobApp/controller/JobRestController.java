package com.AkashKannapiran.JobApp.controller;

import com.AkashKannapiran.JobApp.model.JobPost;
import com.AkashKannapiran.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<JobPost>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PostMapping("/job")
    public ResponseEntity<?> addJob(@RequestBody JobPost job) {
        jobService.addJob(job);
        try {
            return new ResponseEntity<>(jobService.getJob(job.getPostID()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/job/{postID}")
    public ResponseEntity<JobPost> getJob(@PathVariable("postID") int postID) {
        JobPost job = jobService.getJob(postID);

        if (job.getPostID() > 0) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/job")
    public ResponseEntity<?> updateJob(@RequestBody JobPost job) {
        try {
            jobService.updateJob(job);
            return new ResponseEntity<>(jobService.getJob(job.getPostID()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/job/{postID}")
    public ResponseEntity<String> deleteJob(@PathVariable int postID) {
        JobPost job = jobService.getJob(postID);

        if (job.getPostID() > 0) {
            jobService.deleteJob(postID);
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/jobs/keyword/{keyword}")
    public ResponseEntity<List<JobPost>> searchByKeyword(@PathVariable("keyword") String keyword) {
        List<JobPost> job = jobService.searchByKeyword(keyword);

        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("/load")
    public ResponseEntity<String> loadJobs() {
        jobService.loadJobs();
        return new ResponseEntity<>("Jobs loaded successfully", HttpStatus.OK);
    }
}

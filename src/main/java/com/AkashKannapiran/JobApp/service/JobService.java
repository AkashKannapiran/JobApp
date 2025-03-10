package com.AkashKannapiran.JobApp.service;

import com.AkashKannapiran.JobApp.model.JobPost;
import com.AkashKannapiran.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    public void addJob(JobPost job) {
        jobRepo.save(job);
    }

    public JobPost getJob(int postID) {
        return jobRepo.findById(postID).orElse(new JobPost());
    }

    public void updateJob(JobPost job) {
        jobRepo.save(job);
    }

    public void deleteJob(int postID) {
        jobRepo.deleteById(postID);
    }

    public void loadJobs() {
        List<JobPost> jobs =
                new ArrayList<>(Arrays.asList(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
                ));

        jobRepo.saveAll(jobs);
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}

package com.AkashKannapiran.JobApp.repo;

import com.AkashKannapiran.JobApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    public List<JobPost> jobs =
            new ArrayList<>(Arrays.asList(
                    new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                    new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                    new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                    new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                    new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
            ));


    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost job) {
        jobs.add(job);
    }

    public JobPost getJob(int postID) {
        for (JobPost job : jobs) {
            if (job.getPostID() == postID) {
                return job;
            }
        }
        return new JobPost();
    }

    public void updateJob(JobPost job) {
        for (JobPost listJob : jobs) {
            if (listJob.getPostID() == job.getPostID()) {
                listJob.setPostProfile(job.getPostProfile());
                listJob.setPostDesc(job.getPostDesc());
                listJob.setReqExp(job.getReqExp());
                listJob.setPostTechStack(job.getPostTechStack());
            }
        }
    }

    public void deleteJob(int postID) {
        for (JobPost job : jobs) {
            if (job.getPostID() == postID) {
                jobs.remove(job);
            }
        }
    }
}

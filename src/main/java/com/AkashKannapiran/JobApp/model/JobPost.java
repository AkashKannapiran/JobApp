package com.AkashKannapiran.JobApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Entity
public class JobPost {
    @Id
    private int postID;
    private String postProfile;
    private String postDesc;
    private int reqExp;
    private List<String> postTechStack;

    public JobPost() {
    }

    public JobPost(int postID, String postProfile, String postDesc, int reqExp, List<String> postTechStack) {
        this.postID = postID;
        this.postProfile = postProfile;
        this.postDesc = postDesc;
        this.reqExp = reqExp;
        this.postTechStack = postTechStack;
    }

    public int getPostID() {
        return postID;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public int getReqExp() {
        return reqExp;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }
}

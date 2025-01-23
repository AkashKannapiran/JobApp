package com.AkashKannapiran.JobApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int postID;
    private String postProfile;
    private String postDesc;
    private int reqExp;
    private List<String> postTechStack;
}

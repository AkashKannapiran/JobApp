package com.AkashKannapiran.JobApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {
    @Id
    private int postID;
    private String postProfile;
    private String postDesc;
    private int reqExp;
    private List<String> postTechStack;

}

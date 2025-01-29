package com.AkashKannapiran.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.AkashKannapiran.JobApp.service.JobService.*(..)) && args(postID)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postID) throws Throwable {
        LOGGER.info("PostID is negative : " + postID + " Updating it!");

        if (postID < 0) {
            postID = -postID;
        }

        Object obj = jp.proceed(new Object[]{postID});

        LOGGER.info("Updated PostID is : " + postID);

        return obj;
    }
}

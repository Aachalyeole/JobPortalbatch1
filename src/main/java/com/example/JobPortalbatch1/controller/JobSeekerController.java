package com.example.JobPortalbatch1.controller;

import com.example.JobPortalbatch1.model.JobSeekerProfile;
import com.example.JobPortalbatch1.service.JobSeekerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {

    private  final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/create")
    public ResponseEntity<JobSeekerProfile> createOrUpdateJobSeeker(@RequestParam long userId, @RequestBody JobSeekerProfile jobSeekerProfile){
        JobSeekerProfile jobSeekerProfile1=jobSeekerService.createOrUpdateJobSeeker(userId,jobSeekerProfile);
       return ResponseEntity.ok(jobSeekerProfile1);
    }
    @GetMapping("/get")
    public ResponseEntity<JobSeekerProfile> getJobSeeker(@RequestParam long userId){
        JobSeekerProfile jobSeekerProfile=jobSeekerService.getJobSeeker(userId);
        return ResponseEntity.ok(jobSeekerProfile);
    }
}

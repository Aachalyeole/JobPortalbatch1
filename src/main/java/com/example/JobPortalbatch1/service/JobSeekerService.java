package com.example.JobPortalbatch1.service;

import com.example.JobPortalbatch1.model.JobSeekerProfile;
import com.example.JobPortalbatch1.repository.JobSeekerRepository;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;

    public JobSeekerService(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    private final UserRepository userRepository;

    public JobSeekerProfile createOrUpdateJobSeeker(long userId, JobSeekerProfile jobSeekerProfile) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        JobSeekerProfile existingProfile = jobSeekerRepository.findByUserId(userId);

        if (existingProfile != null) {
            existingProfile.setCertifications(jobSeekerProfile.getCertifications());
            existingProfile.setUrl(jobSeekerProfile.getUrl());
            existingProfile.setSkills(jobSeekerProfile.getSkills());
            existingProfile.setResume(jobSeekerProfile.getResume());
            return jobSeekerRepository.save(existingProfile);
        } else {
            jobSeekerProfile.setUser(user);
            return jobSeekerRepository.save(jobSeekerProfile);
        }
    }

    public JobSeekerProfile getJobSeeker(long userId) {
        JobSeekerProfile jobSeekerProfile=jobSeekerRepository.findByUserId(userId);
        return  jobSeekerProfile;
    }
}

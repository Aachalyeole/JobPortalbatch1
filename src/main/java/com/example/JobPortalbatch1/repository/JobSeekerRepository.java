package com.example.JobPortalbatch1.repository;

import com.example.JobPortalbatch1.model.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeekerProfile,Long> {
    JobSeekerProfile findByUserId(long userId);
}

package com.the_jobs.job_seeker_backend.repo;

import com.the_jobs.job_seeker_backend.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepo extends JpaRepository<JobSeeker, Long> {
}

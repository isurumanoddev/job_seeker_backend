package com.the_jobs.job_seeker_backend.repo;

import com.the_jobs.job_seeker_backend.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepo extends JpaRepository<Consultant, Long> {
}

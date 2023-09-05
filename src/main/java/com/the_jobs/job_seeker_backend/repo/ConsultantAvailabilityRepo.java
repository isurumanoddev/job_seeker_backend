package com.the_jobs.job_seeker_backend.repo;

import com.the_jobs.job_seeker_backend.entity.Consultant;
import com.the_jobs.job_seeker_backend.entity.ConsultantAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultantAvailabilityRepo extends JpaRepository<ConsultantAvailability, Long> {
    List<ConsultantAvailability> getAllByConsultant(Consultant consultant);

    ConsultantAvailability findByConsultant(Consultant consultant);
}


package com.the_jobs.job_seeker_backend.repo;


import com.the_jobs.job_seeker_backend.entity.Appointment;
import com.the_jobs.job_seeker_backend.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> getAllByConsultant(Consultant consultant);
}

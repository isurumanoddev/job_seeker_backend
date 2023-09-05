package com.the_jobs.job_seeker_backend.service;




import com.the_jobs.job_seeker_backend.dto.JobSeekerDto;

import java.util.List;

public interface JobSeekerService {
    boolean add_seeker(JobSeekerDto jobSeekerDto);

    List<JobSeekerDto> get_all();

    boolean update_seeker(JobSeekerDto jobSeekerDto);

    boolean delete_seeker(long id);
}

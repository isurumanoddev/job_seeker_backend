package com.the_jobs.job_seeker_backend.service;


import com.the_jobs.job_seeker_backend.dto.ConsultantAvailabilityDto;

import java.util.List;

public interface ConsultantAvailabilityService {
    boolean add_availability(ConsultantAvailabilityDto consultantAvailabilityDto);

    List<ConsultantAvailabilityDto> get_all();

    boolean update_availability(ConsultantAvailabilityDto consultantDto);

    boolean delete_availability(long id);

    List<ConsultantAvailabilityDto> get_all_availability_by_consultant(long id);
}

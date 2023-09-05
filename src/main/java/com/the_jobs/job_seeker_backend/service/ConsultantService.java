package com.the_jobs.job_seeker_backend.service;


import com.the_jobs.job_seeker_backend.dto.ConsultantDto;

import java.util.List;

public interface ConsultantService {
    boolean add_consultant(ConsultantDto consultantDto);

    List<ConsultantDto> get_all();

    boolean update_consultant(ConsultantDto consultantDto);

    boolean delete_consultant(long id);
}

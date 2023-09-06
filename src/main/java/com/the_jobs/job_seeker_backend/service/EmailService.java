package com.the_jobs.job_seeker_backend.service;


import com.the_jobs.job_seeker_backend.dto.EmailDto;

public interface EmailService {
    String sendEmail(EmailDto emailDto);

}

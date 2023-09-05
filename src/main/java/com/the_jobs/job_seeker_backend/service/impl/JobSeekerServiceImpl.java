package com.the_jobs.job_seeker_backend.service.impl;
import com.the_jobs.job_seeker_backend.dto.JobSeekerDto;
import com.the_jobs.job_seeker_backend.entity.JobSeeker;
import com.the_jobs.job_seeker_backend.repo.JobSeekerRepo;
import com.the_jobs.job_seeker_backend.service.JobSeekerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JobSeekerRepo jobSeekerRepo;

    @Override
    public boolean add_seeker(JobSeekerDto jobSeekerDto) {
        JobSeeker seeker = new JobSeeker();
        seeker.setName(jobSeekerDto.getName());
        seeker.setGender(jobSeekerDto.getGender());
        seeker.setEmail(jobSeekerDto.getEmail());
        seeker.setCountry(jobSeekerDto.getCountry());
        seeker.setAddress(jobSeekerDto.getAddress());
        seeker.setJob_type(jobSeekerDto.getJob_type());
        seeker.setPhone(jobSeekerDto.getPhone());
        jobSeekerRepo.save(seeker);
        return true;
    }

    @Override
    public List<JobSeekerDto> get_all() {
        return modelMapper.map(jobSeekerRepo.findAll(), new TypeToken<List<JobSeekerDto>>() {
        }.getType());
    }

    @Override
    public boolean update_seeker(JobSeekerDto jobSeekerDto) {
        Optional<JobSeeker> byId = jobSeekerRepo.findById(jobSeekerDto.getId());
        if (byId.isPresent()) {
            JobSeeker seeker = byId.get();
            seeker.setName(jobSeekerDto.getName());
            seeker.setGender(jobSeekerDto.getGender());
            seeker.setEmail(jobSeekerDto.getEmail());
            seeker.setCountry(jobSeekerDto.getCountry());
            seeker.setAddress(jobSeekerDto.getAddress());
            seeker.setJob_type(jobSeekerDto.getJob_type());
            seeker.setPhone(jobSeekerDto.getPhone());
            jobSeekerRepo.save(seeker);
        }
        return true;
    }

    @Override
    public boolean delete_seeker(long id) {
        jobSeekerRepo.deleteById(id);
        return true;
    }
}

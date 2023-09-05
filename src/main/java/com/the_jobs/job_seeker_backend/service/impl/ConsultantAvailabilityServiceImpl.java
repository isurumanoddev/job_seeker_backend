package com.the_jobs.job_seeker_backend.service.impl;
import com.the_jobs.job_seeker_backend.dto.ConsultantAvailabilityDto;
import com.the_jobs.job_seeker_backend.dto.ConsultantDto;
import com.the_jobs.job_seeker_backend.entity.Consultant;
import com.the_jobs.job_seeker_backend.entity.ConsultantAvailability;
import com.the_jobs.job_seeker_backend.repo.ConsultantAvailabilityRepo;
import com.the_jobs.job_seeker_backend.repo.ConsultantRepo;
import com.the_jobs.job_seeker_backend.repo.UserRepo;
import com.the_jobs.job_seeker_backend.service.ConsultantAvailabilityService;
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
public class ConsultantAvailabilityServiceImpl implements ConsultantAvailabilityService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConsultantRepo consultantRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ConsultantAvailabilityRepo consultantAvailabilityRepo;

    @Override
    public boolean add_availability(ConsultantAvailabilityDto consultantAvailabilityDto) {
        ConsultantAvailability consultantAvailability = new ConsultantAvailability();
        consultantAvailability.setDate(consultantAvailabilityDto.getDate());
        consultantAvailability.setStartTime(consultantAvailabilityDto.getStartTime());
        consultantAvailability.setEndTime(consultantAvailabilityDto.getEndTime());
        Optional<Consultant> byId = consultantRepo.findById(consultantAvailabilityDto.getConsultant().getId());
        if (byId.isPresent()) {
            Consultant consultant = byId.get();
            consultantAvailability.setConsultant(consultant);
        }
        consultantAvailabilityRepo.save(consultantAvailability);
        return true;
    }

    @Override
    public List<ConsultantAvailabilityDto> get_all() {
        List<ConsultantAvailabilityDto> consultantAvailabilityDtos = new ArrayList<>();
        for (ConsultantAvailability consultantAvailability : consultantAvailabilityRepo.findAll()) {
            ConsultantAvailabilityDto consultantAvailabilityDto = new ConsultantAvailabilityDto();
            consultantAvailabilityDto.setDate(consultantAvailability.getDate());
            consultantAvailabilityDto.setStartTime(consultantAvailability.getStartTime());
            consultantAvailabilityDto.setEndTime(consultantAvailability.getEndTime());
            consultantAvailabilityDto.setId(consultantAvailability.getId());
            Optional<Consultant> byId = consultantRepo.findById(consultantAvailability.getConsultant().getId());
            Consultant consultant = byId.get();
            ConsultantDto consultantDto = new ConsultantDto();
            consultantDto.setId(consultant.getId());
            consultantDto.setCountry(consultant.getCountry());
            consultantDto.setJob_type(consultant.getJob_type());
            consultantAvailabilityDto.setConsultant(consultantDto);
            consultantAvailabilityDtos.add(consultantAvailabilityDto);
        }

        return consultantAvailabilityDtos;
    }

    @Override
    public boolean update_availability(ConsultantAvailabilityDto consultantAvailabilityDto) {
        Optional<ConsultantAvailability> byId1 = consultantAvailabilityRepo.findById(consultantAvailabilityDto.getId());
        ConsultantAvailability consultantAvailability = byId1.get();
        consultantAvailability.setDate(consultantAvailabilityDto.getDate());
        consultantAvailability.setStartTime(consultantAvailabilityDto.getStartTime());
        consultantAvailability.setEndTime(consultantAvailabilityDto.getEndTime());
        consultantAvailabilityRepo.save(consultantAvailability);
        return true;
    }

    @Override
    public boolean delete_availability(long id) {
        consultantAvailabilityRepo.deleteById(id);
        return true;
    }

    @Override
    public List<ConsultantAvailabilityDto> get_all_availability_by_consultant(long id) {
        List<ConsultantAvailabilityDto> consultantAvailabilityDtos = new ArrayList<>();
        Consultant consultant = new Consultant();
        consultant.setId(id);
        for (ConsultantAvailability consultantAvailability : consultantAvailabilityRepo.getAllByConsultant(consultant)) {
            ConsultantAvailabilityDto consultantAvailabilityDto = new ConsultantAvailabilityDto();
            consultantAvailabilityDto.setDate(consultantAvailability.getDate());
            consultantAvailabilityDto.setStartTime(consultantAvailability.getStartTime());
            consultantAvailabilityDto.setEndTime(consultantAvailability.getEndTime());
            consultantAvailabilityDto.setId(consultantAvailability.getId());
            consultantAvailabilityDtos.add(consultantAvailabilityDto);
        }

        return consultantAvailabilityDtos;
    }
}

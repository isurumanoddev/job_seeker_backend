package com.the_jobs.job_seeker_backend.service.impl;
import com.the_jobs.job_seeker_backend.dto.ConsultantDto;
import com.the_jobs.job_seeker_backend.dto.UserDto;
import com.the_jobs.job_seeker_backend.entity.Consultant;
import com.the_jobs.job_seeker_backend.entity.ConsultantAvailability;
import com.the_jobs.job_seeker_backend.entity.User;
import com.the_jobs.job_seeker_backend.repo.ConsultantAvailabilityRepo;
import com.the_jobs.job_seeker_backend.repo.ConsultantRepo;
import com.the_jobs.job_seeker_backend.repo.UserRepo;
import com.the_jobs.job_seeker_backend.service.ConsultantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsultantServiceImpl implements ConsultantService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConsultantRepo consultantRepo;

    @Autowired
    ConsultantAvailabilityRepo consultantAvailabilityRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean add_consultant(ConsultantDto consultantDto) {
        Consultant consultant = new Consultant();
        consultant.setCountry(consultantDto.getCountry());
        consultant.setJob_type(consultantDto.getJob_type());
        User user = new User();
        user.setName(consultantDto.getUser().getName());
        user.setRole(consultantDto.getUser().getRole());
        user.setUsername(consultantDto.getUser().getUsername());
        String encode = passwordEncoder.encode(consultantDto.getUser().getPassword());
        user.setPassword(encode);
        consultant.setUser(user);
        consultantRepo.save(consultant);
        return true;
    }

    @Override
    public List<ConsultantDto> get_all() {
        List<ConsultantDto> userDtos = new ArrayList<>();
        for (Consultant consultant : consultantRepo.findAll()) {
            ConsultantDto consultantDto = new ConsultantDto();
            consultantDto.setCountry(consultant.getCountry());
            consultantDto.setJob_type(consultant.getJob_type());
            consultantDto.setId(consultant.getId());
            User user = consultant.getUser();
            UserDto userDTO = new UserDto();
            userDTO.setRole(user.getRole());
            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setId(user.getId());
            consultantDto.setUser(userDTO);
            userDtos.add(consultantDto);
        }

        return userDtos;
    }

    @Override
    public boolean update_consultant(ConsultantDto consultantDto) {
        Optional<Consultant> byId = consultantRepo.findById(consultantDto.getId());

        if (byId.isPresent()) {
            Consultant consultant = byId.get();
            consultant.setCountry(consultantDto.getCountry());
            consultant.setJob_type(consultantDto.getJob_type());
            Optional<User> byId1 = userRepo.findById(consultant.getUser().getId());
            User user = byId1.get();
            user.setName(consultantDto.getUser().getName());
            user.setRole(consultantDto.getUser().getRole());
            user.setUsername(consultantDto.getUser().getUsername());
            String encode = passwordEncoder.encode(consultantDto.getUser().getPassword());
            user.setPassword(encode);
            consultant.setUser(user);
            consultantRepo.save(consultant);
        }
        return true;
    }

    @Override
    public boolean delete_consultant(long id) {
        Optional<Consultant> byId = consultantRepo.findById(id);
        Consultant consultant = byId.get();
        ConsultantAvailability byConsultant = consultantAvailabilityRepo.findByConsultant(consultant);
        consultantAvailabilityRepo.deleteById(byConsultant.getId());
        consultantRepo.deleteById(id);
        userRepo.findById(consultant.getUser().getId());
        return true;
    }
}

package com.the_jobs.job_seeker_backend.service.impl;
import com.the_jobs.job_seeker_backend.dto.UserDto;
import com.the_jobs.job_seeker_backend.entity.User;
import com.the_jobs.job_seeker_backend.service.EmailService;
import com.the_jobs.job_seeker_backend.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    com.the_jobs.job_seeker_backend.repo.UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @Override
    public boolean add_user(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        user.setUsername(userDTO.getUsername());

        String encode = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encode);
        userRepo.save(user);
//        EmailDto emailDto = new EmailDto();
//        emailDto.setMsg_body("Your Username: " + userDTO.getUsername() + "\n" + "Your Password: " + userDTO.getPassword());
//        emailDto.setTo_mail("your_mail");
//        emailDto.setSubject("User registration");
//        emailService.sendEmail(emailDto);
        return true;
    }

    @Override
    public List<UserDto> get_all() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            UserDto userDTO = new UserDto();
            userDTO.setRole(user.getRole());
            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setId(user.getId());
            userDtos.add(userDTO);
        }
        return userDtos;
    }

    @Override
    public boolean update_user(UserDto userDTO) {
        Optional<User> byId = userRepo.findById(userDTO.getId());
        if (byId.isPresent()) {
            User user = byId.get();
            user.setName(userDTO.getName());
            user.setRole(userDTO.getRole());
            user.setUsername(userDTO.getUsername());

            String encode = passwordEncoder.encode(userDTO.getPassword());
            user.setPassword(encode);
            userRepo.save(user);
        }
        return true;
    }

    @Override
    public boolean delete_user(long id) {
        userRepo.deleteById(id);
        return true;
    }

    @Override
    public Object get_user_by_username(String username) {
        Optional<User> byUsername = userRepo.findByUsername(username);
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            UserDto userDTO = new UserDto();
            userDTO.setRole(user.getRole());
            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setId(user.getId());
            return userDTO;
        }
        return null;
    }
}

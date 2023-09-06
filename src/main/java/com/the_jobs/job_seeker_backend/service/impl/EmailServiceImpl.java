package com.the_jobs.job_seeker_backend.service.impl;
import com.the_jobs.job_seeker_backend.dto.EmailDto;
import com.the_jobs.job_seeker_backend.repo.UserRepo;
import com.the_jobs.job_seeker_backend.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public String sendEmail(EmailDto emailDto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("sdckeylogger@gmail.com");
        mailMessage.setTo(emailDto.getTo_mail());
        mailMessage.setText(emailDto.getMsg_body());
        mailMessage.setSubject(emailDto.getSubject());
        emailSender.send(mailMessage);
        return null;
    }
}

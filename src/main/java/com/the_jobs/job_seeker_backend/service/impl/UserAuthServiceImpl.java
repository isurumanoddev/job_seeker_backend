package com.the_jobs.job_seeker_backend.service.impl;
import com.the_jobs.job_seeker_backend.entity.User;
import com.the_jobs.job_seeker_backend.repo.UserRepo;
import com.the_jobs.job_seeker_backend.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userAuthService")
public class UserAuthServiceImpl implements UserDetailsService, UserAuthService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepo.getByUsername(username);
            if (user == null) throw new UsernameNotFoundException("Invalid username password.");
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List getAuthority(User user) {
        return Arrays.asList(new SimpleGrantedAuthority(user.getRole().name()));
    }
}

package com.the_jobs.job_seeker_backend.repo;

import com.the_jobs.job_seeker_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);
}

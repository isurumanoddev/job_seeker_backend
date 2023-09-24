package com.the_jobs.job_seeker_backend.service;



import com.the_jobs.job_seeker_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    boolean add_user(UserDto userDTO);

    List<UserDto> get_all();

    boolean update_user(UserDto userDTO);

    boolean delete_user(long id);

    Object get_user_by_username(String username);
}

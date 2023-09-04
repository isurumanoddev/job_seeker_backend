package com.the_jobs.job_seeker_backend.service;


import com.the_jobs.job_seeker_backend.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    boolean add_appointment(AppointmentDto appointmentDto);

    List<AppointmentDto> get_all();

    boolean update_appointment(AppointmentDto appointmentDto);

    boolean delete_appointment(long id);

    List<AppointmentDto> get_all_appointment_by_consultant(long id);
}

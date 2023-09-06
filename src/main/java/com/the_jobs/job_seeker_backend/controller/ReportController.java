package com.the_jobs.job_seeker_backend.controller;

import com.the_jobs.job_seeker_backend.configuration.CommonResponse;
import com.the_jobs.job_seeker_backend.service.AppointmentService;
import com.the_jobs.job_seeker_backend.service.ConsultantAvailabilityService;
import com.the_jobs.job_seeker_backend.service.ConsultantService;
import com.the_jobs.job_seeker_backend.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ConsultantService consultantService;

    @Autowired
    JobSeekerService seekerService;

    @Autowired
    ConsultantAvailabilityService consultantAvailabilityService;

    @GetMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_appointments() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", appointmentService.get_all()));
    }

    @GetMapping(value = "/consultants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_consultant() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", consultantService.get_all()));
    }

    @GetMapping(value = "/seekers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_seekers() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", seekerService.get_all()));
    }

    @GetMapping(value = "/availability", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_availability() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", consultantAvailabilityService.get_all()));
    }
}

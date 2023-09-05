package com.the_jobs.job_seeker_backend.controller;


import com.the_jobs.job_seeker_backend.configuration.CommonResponse;
import com.the_jobs.job_seeker_backend.dto.ConsultantDto;
import com.the_jobs.job_seeker_backend.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/consultant")
public class ConsultantController {
    @Autowired
    ConsultantService consultantService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> add_consultant(@RequestBody ConsultantDto consultantDto) {
        consultantService.add_consultant(consultantDto);
        return ResponseEntity.ok(new CommonResponse(200, "Saved", null));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_consultant() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", consultantService.get_all()));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> update_consultant(@RequestBody ConsultantDto consultantDto) {
        consultantService.update_consultant(consultantDto);
        return ResponseEntity.ok(new CommonResponse(200, "Updated", null));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> delete_consultant(@PathVariable(value = "id") long id) {
        consultantService.delete_consultant(id);
        return ResponseEntity.ok(new CommonResponse(200, "Deleted", null));
    }
}

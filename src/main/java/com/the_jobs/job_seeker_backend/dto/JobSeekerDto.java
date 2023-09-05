
package com.the_jobs.job_seeker_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobSeekerDto {
    private long id;
    private String name;
    private String address;
    private String gender;
    private String phone;
    private String country;
    private String job_type;
    private String email;
}

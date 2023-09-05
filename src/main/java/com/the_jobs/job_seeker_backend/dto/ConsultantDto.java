
package com.the_jobs.job_seeker_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultantDto {
    private long id;
    private String job_type;
    private String country;
    private UserDto user;
}

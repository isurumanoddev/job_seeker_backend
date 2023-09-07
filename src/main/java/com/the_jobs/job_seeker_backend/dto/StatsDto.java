
package com.the_jobs.job_seeker_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatsDto {
    private long totalAppointment;
    private long totalConsultants;
    private long totalSeekers;
    private long totalAvailability;
}

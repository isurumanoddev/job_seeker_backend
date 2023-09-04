
package com.the_jobs.job_seeker_backend.configuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResponse {
    private int status;
    private String message;
    private Object data;
}

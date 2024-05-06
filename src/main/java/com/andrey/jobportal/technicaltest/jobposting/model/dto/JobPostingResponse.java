package com.andrey.jobportal.technicaltest.jobposting.model.dto;

import com.andrey.jobportal.technicaltest.jobposting.model.JobStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingResponse {
    private Long id;
    private String title;
    private String description;
    private String salary;
    private JobStatus jobStatus;
    private String type;
    private Long employerId;
}

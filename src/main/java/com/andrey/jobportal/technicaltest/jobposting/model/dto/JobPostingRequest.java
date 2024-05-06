package com.andrey.jobportal.technicaltest.jobposting.model.dto;

import com.andrey.jobportal.technicaltest.employer.model.Employer;
import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.jobposting.model.JobStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingRequest {

    private String title;
    private String description;
    private String salary;
    private JobStatus jobStatus;
    private String type;
    private Long employerId;

    public JobPosting convertToEntity() {

        Employer employer = Employer.builder().id(this.employerId).build();

        return JobPosting.builder()
                .title(this.title)
                .description(this.description)
                .salary(this.salary)
                .jobStatus(this.jobStatus)
                .type(this.type)
                .employer(employer)
                .build();
    }
}

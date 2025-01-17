package com.andrey.jobportal.technicaltest.jobposting.model;

import java.util.List;

import com.andrey.jobportal.technicaltest.employer.model.Employer;
import com.andrey.jobportal.technicaltest.jobposting.model.dto.JobPostingResponse;
import com.andrey.jobportal.technicaltest.proposal.model.Proposal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String company;
    private String salary;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;
    private String type;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToMany(mappedBy = "jobPosting")
    private List<Proposal> proposals;

    public JobPostingResponse convertToResponse() {
        return JobPostingResponse.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .company(this.company)
                .salary(this.salary)
                .jobStatus(this.jobStatus)
                .type(this.type)
                .employerId(this.employer.getId())
                .build();
    }
}

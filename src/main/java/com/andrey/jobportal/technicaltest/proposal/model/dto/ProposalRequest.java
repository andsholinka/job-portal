package com.andrey.jobportal.technicaltest.proposal.model.dto;

import com.andrey.jobportal.technicaltest.freelancer.model.Freelancer;
import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.proposal.model.Proposal;
import com.andrey.jobportal.technicaltest.proposal.model.ProposalStatus;

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
public class ProposalRequest {
    private String coverLetter;
    private String resume;
    private String portfolio;
    private Double amount;
    private Long jobPostingId;
    private Long freelancerId;

    public Proposal convertToEntity() {

        Freelancer freelancer = Freelancer.builder().id(this.freelancerId).build();
        JobPosting jobPosting = JobPosting.builder().id(this.jobPostingId).build();

        return Proposal.builder()
                .coverLetter(this.coverLetter)
                .resume(this.resume)
                .portfolio(this.portfolio)
                .amount(this.amount)
                .jobPosting(jobPosting)
                .freelancer(freelancer)
                .build();
    }
}

package com.andrey.jobportal.technicaltest.proposal.model;

import com.andrey.jobportal.technicaltest.freelancer.model.Freelancer;
import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.proposal.model.dto.ProposalResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coverLetter;
    private String resume;
    private String portfolio;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ProposalStatus proposalStatus = ProposalStatus.APPLIED;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    public ProposalResponse convertToResponse() {
        return ProposalResponse.builder()
                .id(this.id)
                .coverLetter(this.coverLetter)
                .resume(this.resume)
                .portfolio(this.portfolio)
                .proposalStatus(this.proposalStatus)
                .amount(this.amount)
                .jobPostingId(this.jobPosting.getId())
                .freelancerId(this.freelancer.getId())
                .build();
    }
}

package com.andrey.jobportal.technicaltest.proposal.model.dto;

import com.andrey.jobportal.technicaltest.proposal.model.ProposalStatus;

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
public class ProposalResponse {
    private Long id;
    private String coverLetter;
    private String resume;
    private String portfolio;
    private ProposalStatus proposalStatus;
    private Double amount;
    private Long jobPostingId;
    private Long freelancerId;
}

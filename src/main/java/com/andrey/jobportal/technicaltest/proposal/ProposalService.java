package com.andrey.jobportal.technicaltest.proposal;

import org.springframework.stereotype.Service;

import com.andrey.jobportal.technicaltest.proposal.model.Proposal;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProposalService {
    private final ProposalRepository proposalRepository;

    public Proposal save(Proposal proposal) {
        return this.proposalRepository.save(proposal);
    }
}

package com.andrey.jobportal.technicaltest.proposal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.jobportal.technicaltest.proposal.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}

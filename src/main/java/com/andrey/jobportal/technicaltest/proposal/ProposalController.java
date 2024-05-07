package com.andrey.jobportal.technicaltest.proposal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andrey.jobportal.technicaltest.proposal.model.Proposal;
import com.andrey.jobportal.technicaltest.proposal.model.dto.ProposalRequest;
import com.andrey.jobportal.technicaltest.proposal.model.dto.ProposalResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProposalController {
    private final ProposalService proposalService;

    @PostMapping("/proposals")
    public ResponseEntity<ProposalResponse> createProposal(@RequestBody ProposalRequest proposalRequest) {

        Proposal proposal = this.proposalService.save(proposalRequest.convertToEntity());
        ProposalResponse proposalResponse = proposal.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(proposalResponse);
    }
}

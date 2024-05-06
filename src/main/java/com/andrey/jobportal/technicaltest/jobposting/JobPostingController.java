package com.andrey.jobportal.technicaltest.jobposting;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.jobposting.model.dto.JobPostingRequest;
import com.andrey.jobportal.technicaltest.jobposting.model.dto.JobPostingResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JobPostingController {
    private final JobPostingService jobPostingService;

    @GetMapping("/job-postings")
    public ResponseEntity<List<JobPostingResponse>> getJobPostings() {

        List<JobPosting> jobPostings = this.jobPostingService.getJobPostings();
        List<JobPostingResponse> jobPostingResponses = jobPostings.stream()
                .map(jobPosting -> jobPosting.convertToResponse()).toList();

        return ResponseEntity.ok().body(jobPostingResponses);
    }
}

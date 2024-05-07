package com.andrey.jobportal.technicaltest.jobposting;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.jobposting.model.JobStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;

    public JobPosting save(JobPosting jobPosting) {
        return this.jobPostingRepository.save(jobPosting);
    }

    public List<JobPosting> getJobPostings(JobStatus status) {
        if (status != null) {
            return this.jobPostingRepository.findAllByJobStatus(status);
        } else {
            return this.jobPostingRepository.findAll();
        }
    }
}

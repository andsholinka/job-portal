package com.andrey.jobportal.technicaltest.jobposting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.jobposting.model.JobStatus;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

    List<JobPosting> findAllByJobStatus(JobStatus status);

}

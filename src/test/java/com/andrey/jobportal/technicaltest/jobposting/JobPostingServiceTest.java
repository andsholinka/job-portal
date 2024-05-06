package com.andrey.jobportal.technicaltest.jobposting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.jobposting.model.JobStatus;

@SpringBootTest
public class JobPostingServiceTest {
    @InjectMocks
    private JobPostingService jobPostingService;

    @Mock
    private JobPostingRepository jobPostingRepository;

    @Test
    void save_shouldCreateJobPosting_whenGivenANewJobPosting() {
        JobPosting jobPosting = JobPosting.builder()
                .title("Software Engineer")
                .description("We are looking for a software engineer to join our team")
                .jobStatus(JobStatus.DRAFT)
                .build();
        JobPosting expectedResult = JobPosting.builder()
                .id(1L)
                .title("Software Engineer")
                .description("We are looking for a software engineer to join our team")
                .jobStatus(JobStatus.DRAFT)
                .build();
        Mockito.when(this.jobPostingRepository.save(jobPosting)).thenReturn(expectedResult);

        JobPosting actualResult = this.jobPostingService.save(jobPosting);

        Mockito.verify(this.jobPostingRepository).save(jobPosting);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}

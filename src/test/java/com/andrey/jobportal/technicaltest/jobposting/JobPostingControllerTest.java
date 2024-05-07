package com.andrey.jobportal.technicaltest.jobposting;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.andrey.jobportal.technicaltest.employer.EmployerRepository;
import com.andrey.jobportal.technicaltest.employer.model.Employer;
import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;
import com.andrey.jobportal.technicaltest.jobposting.model.JobStatus;
import com.andrey.jobportal.technicaltest.jobposting.model.dto.JobPostingRequest;
import com.andrey.jobportal.technicaltest.jobposting.model.dto.JobPostingResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class JobPostingControllerTest {
        @Autowired
        private MockMvc client;

        @Autowired
        private ObjectMapper objectMapper;

        @Autowired
        private JobPostingRepository jobPostingRepository;

        @Autowired
        private EmployerRepository employerRepository;

        @BeforeEach
        void setUp() {

                Employer employer = Employer.builder()
                                .id(1L)
                                .name("Andrey")
                                .build();

                Employer savedEmployer = this.employerRepository.save(employer);

                JobPosting jobPosting = JobPosting.builder()
                                .title("Software Engineer")
                                .description("We are looking for a software engineer to join our team")
                                .jobStatus(JobStatus.DRAFT)
                                .employer(savedEmployer)
                                .build();

                JobPosting jobPostingPublished = JobPosting.builder()
                                .title("Backend Engineer")
                                .description("We are looking for a backend engineer to join our team")
                                .jobStatus(JobStatus.PUBLISHED)
                                .employer(savedEmployer)
                                .build();

                this.jobPostingRepository.saveAll(List.of(jobPosting, jobPostingPublished));
        }

        @AfterEach
        void tearDown() {
                this.jobPostingRepository.deleteAll();
        }

        @Test
        void getJobPostings_shouldReturnAllJobPostings_whenCalled() throws Exception {
                List<JobPosting> jobPostings = this.jobPostingRepository.findAll();
                List<JobPostingResponse> expectedResult = jobPostings.stream().map(JobPosting::convertToResponse)
                                .toList();
                int expectedResultSize = expectedResult.size();

                MvcResult result = this.client
                                .perform(MockMvcRequestBuilders.get("/job-postings"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andReturn();
                String actualResultString = result.getResponse().getContentAsString();
                List<JobPostingResponse> actualResult = this.objectMapper.readValue(actualResultString,
                                new TypeReference<List<JobPostingResponse>>() {
                                });

                Assertions.assertEquals(expectedResultSize, actualResult.size());
                Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        void getJobPostings_shouldReturnAllJobPostingsWithStatusPublished_whenCalled() throws Exception {
                List<JobPosting> jobPostings = this.jobPostingRepository.findAllByJobStatus(JobStatus.PUBLISHED);
                List<JobPostingResponse> expectedResult = jobPostings.stream().map(JobPosting::convertToResponse)
                                .toList();
                int expectedResultSize = expectedResult.size();

                MvcResult result = this.client
                                .perform(MockMvcRequestBuilders.get("/job-postings?status=PUBLISHED"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andReturn();
                String actualResultString = result.getResponse().getContentAsString();
                List<JobPostingResponse> actualResult = this.objectMapper.readValue(actualResultString,
                                new TypeReference<List<JobPostingResponse>>() {
                                });

                Assertions.assertEquals(expectedResultSize, actualResult.size());
                Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        void createJobPosting_shouldCreateJobPosting_whenCalled() throws Exception {
                JobPostingRequest jobPostingRequest = JobPostingRequest.builder()
                                .title("Software Engineer")
                                .description("We are looking for a software engineer to join our team")
                                .jobStatus(JobStatus.DRAFT)
                                .employerId(1L)
                                .build();
                String requestBody = this.objectMapper.writeValueAsString(jobPostingRequest);
                JobPostingResponse expectedResult = jobPostingRequest.convertToEntity().convertToResponse();

                MvcResult result = this.client
                                .perform(MockMvcRequestBuilders.post("/job-postings")
                                                .content(requestBody)
                                                .contentType("application/json"))
                                .andExpect(MockMvcResultMatchers.status().isCreated())
                                .andReturn();
                String actualResultString = result.getResponse().getContentAsString();
                JobPostingResponse actualResult = this.objectMapper.readValue(actualResultString,
                                JobPostingResponse.class);
                expectedResult.setId(actualResult.getId());

                Assertions.assertEquals(expectedResult, actualResult);
        }
}

package com.andrey.jobportal.technicaltest.employer.model;

import java.util.List;

import com.andrey.jobportal.technicaltest.customer.model.Customer;
import com.andrey.jobportal.technicaltest.jobposting.model.JobPosting;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends Customer {
    private String company;

    @OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;
}

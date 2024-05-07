package com.andrey.jobportal.technicaltest.freelancer.model;

import java.util.List;

import com.andrey.jobportal.technicaltest.customer.model.Customer;
import com.andrey.jobportal.technicaltest.proposal.model.Proposal;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Freelancer extends Customer {

    @OneToMany(mappedBy = "freelancer")
    private List<Proposal> proposals;
}

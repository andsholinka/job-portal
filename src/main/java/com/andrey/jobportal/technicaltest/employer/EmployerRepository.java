package com.andrey.jobportal.technicaltest.employer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.jobportal.technicaltest.employer.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

}

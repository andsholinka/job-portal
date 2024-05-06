package com.andrey.jobportal.technicaltest.customer.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.andrey.jobportal.technicaltest.applicationuser.ApplicationUser;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private ApplicationUser applicationUser;
}

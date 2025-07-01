package com.booking.cabbooking.domain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String firstName;
    private String lastName;
    private String phoneNo;
    private String address;
    private LocalTime pickUp;
    private LocalTime drop;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}



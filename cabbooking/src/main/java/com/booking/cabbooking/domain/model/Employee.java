package com.booking.cabbooking.domain.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int EmployeeId;
    private String firstName;
    private String lastName;
    private String phoneNo;
}

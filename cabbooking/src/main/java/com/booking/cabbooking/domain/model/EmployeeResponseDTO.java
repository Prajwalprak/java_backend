package com.booking.cabbooking.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponseDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String pickup;
    private String companyName;
}


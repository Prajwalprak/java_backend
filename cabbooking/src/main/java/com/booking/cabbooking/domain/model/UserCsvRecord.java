package com.booking.cabbooking.domain.model;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCsvRecord {

    @CsvBindByName(column = "name")
    //@NotEmpty(message = "Name cannot be empty")
    private String name;

    @CsvBindByName(column = "college")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "College must contain only alphabets")
    private String college;

    @CsvBindByName(column = "location")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Location must be alphanumeric")
    private String location;

    @CsvBindByName(column = "company_name")
    @NotEmpty(message = "Company name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Company name must be alphabets")
    private String companyName;

    @CsvBindByName(column = "company_location")
    @NotEmpty(message = "Company location is required")
    private String companyLocation;
}

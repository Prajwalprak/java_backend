package com.booking.cabbooking.domain.service;

import com.booking.cabbooking.domain.model.Company;

public interface CompanyService {
    public Company addCompany(Company company);
    public Company getCompanyById(Long id);
}

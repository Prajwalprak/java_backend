package com.booking.cabbooking.domain.serviceImpl;

import com.booking.cabbooking.domain.Repository.CompanyRepo;
import com.booking.cabbooking.domain.model.Company;
import com.booking.cabbooking.domain.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
    }
}

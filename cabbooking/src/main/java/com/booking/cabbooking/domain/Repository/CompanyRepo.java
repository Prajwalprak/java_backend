package com.booking.cabbooking.domain.Repository;

import com.booking.cabbooking.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CompanyRepo extends JpaRepository<Company, Long> {
}

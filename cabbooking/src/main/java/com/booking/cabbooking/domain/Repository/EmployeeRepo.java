package com.booking.cabbooking.domain.Repository;

import com.booking.cabbooking.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.address = :address AND e.pickUp = :pickupTime")
    List<Employee> findByAddressAndPickupTime(@Param("address") String address, @Param("pickupTime") LocalTime pickupTime);

}

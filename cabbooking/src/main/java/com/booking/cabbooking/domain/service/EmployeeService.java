package com.booking.cabbooking.domain.service;

import com.booking.cabbooking.domain.model.Company;
import com.booking.cabbooking.domain.model.Employee;
import com.booking.cabbooking.domain.model.EmployeeResponseDTO;

import java.time.LocalTime;
import java.util.List;

public interface EmployeeService {

    public Employee create(Employee employee);

    public List<Employee> getAllData();

    public String deleteEmployee(Integer employeeId);

    public List<Employee> createEmployeeList(List<Employee> emp);

    public List<EmployeeResponseDTO> getEmployeesByAddressAndPickup(String address, LocalTime pickupTime);

}

package com.booking.cabbooking.domain.serviceImpl;

import com.booking.cabbooking.domain.Repository.CompanyRepo;
import com.booking.cabbooking.domain.Repository.EmployeeRepo;
import com.booking.cabbooking.domain.model.Employee;
import com.booking.cabbooking.domain.model.EmployeeResponseDTO;
import com.booking.cabbooking.domain.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    private CompanyRepo companyRepo;

    public EmployeeServiceImpl(EmployeeRepo repo, CompanyRepo companyRepo) {
        this.employeeRepo = repo;
        this.companyRepo = companyRepo;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepo.save(employee);
    }


    @Override
    public List<Employee> getAllData() {
        return employeeRepo.findAll();
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
        Optional<Employee> existingEmployee = employeeRepo.findById(employeeId);

        if(existingEmployee.isPresent()){
            employeeRepo.deleteById(employeeId);
            return "Employee id " +employeeId+ " deleted successfully";
        }else{
            throw new EntityNotFoundException("Not found");
        }
    }

    @Override
    public List<Employee> createEmployeeList(List<Employee> emp) {
        return employeeRepo.saveAll(emp);
    }

    public List<EmployeeResponseDTO> getEmployeesByAddressAndPickup(String address, LocalTime pickupTime) {
        return employeeRepo.findByAddressAndPickupTime(address, pickupTime)
                .stream()
                .map(e -> new EmployeeResponseDTO(
                        e.getFirstName(),
                        e.getLastName(),
                        e.getAddress(),
                        e.getPickUp().toString(),
                        e.getCompany().getCompany_name()
                ))
                .collect(Collectors.toList());
    }



}

package com.booking.cabbooking.domain.serviceImpl;

import com.booking.cabbooking.domain.Repository.EmployeeRepo;
import com.booking.cabbooking.domain.model.Employee;
import com.booking.cabbooking.domain.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo repo;

    public EmployeeServiceImpl(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public Employee create(Employee employee) {
        return repo.save(employee);
    }


    @Override
    public List<Employee> getAllData() {
        return repo.findAll();
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
        Optional<Employee> existingEmployee = repo.findById(employeeId);

        if(existingEmployee.isPresent()){
            repo.deleteById(employeeId);
            return "Employee id " +employeeId+ " deleted successfully";
        }else{
            throw new EntityNotFoundException("Not found");
        }
    }

    @Override
    public List<Employee> createEmployeeList(List<Employee> emp) {
        return repo.saveAll(emp);
    }
}

package com.booking.cabbooking.controller;

import com.booking.cabbooking.domain.model.Employee;
import com.booking.cabbooking.domain.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee emp){
        return employeeService.create(emp);
    }

    @PostMapping("/createEmployeeList")
    public List<Employee> createEmployeeList(@RequestBody List<Employee> emp){
        return employeeService.createEmployeeList(emp);
    }

    @GetMapping("/get")
    public List<Employee> GetAllEmployee(){
        return employeeService.getAllData();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam Integer employeeId){
        try {
            String response = employeeService.deleteEmployee(employeeId);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

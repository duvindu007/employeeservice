package com.employee.employeeService.controller;

import com.employee.employeeService.exception.ResourceNotFoundException;
import com.employee.employeeService.model.Employee;
import com.employee.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getEmployee")
    public List<Employee> getEmployee() {
        return employeeService.getAllEmployees();

    }

    @GetMapping("/getEmpByEmilId/{emailId}")
    public ResponseEntity<Employee> getEmpByEmilId(@PathVariable(value = "emailId") String emailId) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmpByEmilId(emailId);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/updateEmployee/{emailId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "emailId") String email, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmpByEmilId(email);

        employee.setFirstname(employeeDetails.getFirstname());
        employee.setLastname(employeeDetails.getLastname());

        final Employee updateEmployee = employeeService.updateEmployee(employee, email);
        return ResponseEntity.ok(updateEmployee);
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{emailId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "emailId") String emailId) {
        Employee employee = employeeService.getEmpByEmilId(emailId);

        return employeeService.deleteEmployee(employee);

    }


}

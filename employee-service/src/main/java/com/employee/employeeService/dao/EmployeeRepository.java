package com.employee.employeeService.dao;

import com.employee.employeeService.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    public Employee findByEmailId(String emailId);
}

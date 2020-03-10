package com.employee.employeeService.service;

import com.employee.employeeService.dao.EmployeeRepository;
import com.employee.employeeService.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpByEmilId(String emailId) {
        return employeeRepository.findByEmailId(emailId);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, String email) {
        employee.setEmailId(email);
        return employeeRepository.save(employee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Employee employee) {
        Map<String, Boolean> response = new HashMap<>();

        employeeRepository.delete(employee);
        response.put("delete", Boolean.TRUE);

        return response;
    }
}

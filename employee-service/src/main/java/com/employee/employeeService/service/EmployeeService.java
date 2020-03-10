package com.employee.employeeService.service;

import com.employee.employeeService.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmpByEmilId(String emailId);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee,String email);
    public Map<String, Boolean> deleteEmployee(Employee employee);


}

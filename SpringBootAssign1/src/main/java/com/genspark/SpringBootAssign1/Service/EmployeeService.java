package com.genspark.SpringBootAssign1.Service;

import com.genspark.SpringBootAssign1.Entity.Employee;

import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployees();
    Employee getByEmployeeId(int id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(int employeeId);
    
}

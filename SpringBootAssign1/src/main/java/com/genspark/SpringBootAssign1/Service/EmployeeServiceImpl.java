package com.genspark.SpringBootAssign1.Service;


import com.genspark.SpringBootAssign1.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> list;

    public EmployeeServiceImpl() {
        list = new ArrayList<>();
        list.add(new Employee(1,"Employee One", "EmployeeOne@employees.org"));
        list.add(new Employee(2,"Employee Two", "EmployeeTwo@employees.org"));
        list.add(new Employee(3,"Employee Three", "EmployeeThree@employees.org"));
        list.add(new Employee(4,"Employee Four", "EmployeeFour@employees.org"));
    }

    public Employee getByEmployeeId(int id){
        Employee c = null;
        for (Employee employee : this.list){
            if (employee.getEmployeeId() == id) {
                c = employee;
                break;
            }
        }

        return c;
    }

    public List<Employee> getAllEmployees(){
        return list;
    }

    public Employee addEmployee(Employee Employee){
        list.add(Employee);
        return getByEmployeeId(Employee.getEmployeeId());
    }

    public Employee updateEmployee(Employee Employee){
        String title = Employee.getName();
        String instructor = Employee.getEmail();
        Employee c = null;
        for ( Employee e : this.list){
            if (e.getEmployeeId() == Employee.getEmployeeId()){
                e.setName(title);
                e.setEmail(instructor);
                c = e;
                break;
            }
        }
        return c;
    }

    public Employee deleteEmployee(int EmployeeId){
        Employee c = null;
        for ( Employee e : this.list){
            if (e.getEmployeeId() == EmployeeId){
                list.remove(e);
                break;
            }
        }
        return c;
    }

}

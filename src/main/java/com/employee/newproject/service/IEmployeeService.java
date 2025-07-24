package com.employee.newproject.service;


import com.employee.newproject.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    public Employee addEmployee(Employee employee);

    public List<Employee> allEmployee();


    public Optional<Employee> getEmployeeById(Long empId);


    public Optional<Employee> deleteEmployeeById(Long empId);

    public List<Employee> deleteAllEmployee(Employee employee);
    Employee update(Long id, Employee employee);

}

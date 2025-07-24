package com.employee.newproject.service;

import com.employee.newproject.exception.ResourceNotFoundException;
import com.employee.newproject.model.Employee;
import com.employee.newproject.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements IEmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee) ;    }

    @Override
    public List<Employee> allEmployee() {
        return employeeRepo.findAll();    }

    @Override
    public Optional<Employee> getEmployeeById(Long empId) {
        return employeeRepo.findById(empId);
    }

    @Override
    public Optional<Employee> deleteEmployeeById(Long empId) {
        Optional<Employee> e=employeeRepo.findById(empId);
        employeeRepo.deleteById(empId);
        return e;    }

    @Override
    public List<Employee> deleteAllEmployee(Employee employee) {
        List<Employee>employees=employeeRepo.findAll();
        employeeRepo.delete(employee);
        return employees;

    }

    @Override
    public Employee update(Long id, Employee employee) {
        if (!employeeRepo.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);}
        employee.setId(id);
        return employeeRepo.save(employee);
    }


}

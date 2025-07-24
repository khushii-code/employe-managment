//package com.employee.newproject.service;
//
//import com.employee.newproject.model.Employee;
//import com.employee.newproject.repo.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeService {
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//
//    public Employee createEmployee(Employee employee) {
//        return employeeRepo.save(employee) ;
//    }
//
//    public List<Employee> allEmployee() {
//        return employeeRepo.findAll();
//    }
//
//
//    public Optional<Employee> getEmployeeById(Integer empId) {
//
//        return employeeRepo.findById(empId);
//    }
//
//    public Optional<Employee> deleteEmployeeById(Integer empId) {
//        Optional<Employee> e=employeeRepo.findById(empId);
//        employeeRepo.deleteById(empId);
//        return e;
//    }
//
//    public List<Employee> deleteAllEmployee(Employee employee) {
//        List<Employee>employees=employeeRepo.findAll();
//         employeeRepo.delete(employee);
//         return employees;
//
//    }
//}

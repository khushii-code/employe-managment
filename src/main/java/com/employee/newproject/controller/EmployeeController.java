package com.employee.newproject.controller;

import com.employee.newproject.model.Employee;
import com.employee.newproject.service.EmployeeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeService;


    @Operation(summary = "Create a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/add")
    public Employee addEmployee( @Valid @RequestBody Employee employee){

        return employeeService.addEmployee(employee) ;
    }

    @Operation(summary = "Fetch all employees")
    @ApiResponse(responseCode = "200", description = "Employees fetched successfully")
    @GetMapping("/allEmployee")
    public List<Employee> allEmployee(){
        return employeeService.allEmployee();
    }

    @Operation(summary = "Get employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/getEmployeeById/{empId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long empId){

        return employeeService.getEmployeeById(empId);
    }

    @Operation(summary = "Delete an employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @DeleteMapping("/deleteEmployeeById/{empId}")
    public Optional<Employee> deleteEmployeeById(@PathVariable Long empId){
        return employeeService.deleteEmployeeById(empId);
    }


    @Operation(summary = "delete all   employee ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @DeleteMapping("/deleteAllEmployee")
    public List<Employee> deleteAllEmployee(Employee employee){
        return employeeService.deleteAllEmployee(employee);
    }

    @Operation(summary = "Update an employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }
}

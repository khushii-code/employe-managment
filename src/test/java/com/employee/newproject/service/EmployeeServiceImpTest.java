package com.employee.newproject.service;

import com.employee.newproject.exception.ResourceNotFoundException;
import com.employee.newproject.model.Employee;
import com.employee.newproject.repo.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class EmployeeServiceImpTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImp service;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setEmail("john@example.com");
        employee.setDepartment("HR");
        employee.setSalary(5000L);
        employee.setJoiningDate(LocalDate.now());
    }

    @Test
    void testAddEmployee() {
        when(employeeRepo.save(employee)).thenReturn(employee);
        Employee saved = service.addEmployee(employee);
        assertEquals("John", saved.getName());
    }

    @Test
    void testAllEmployee() {
        when(employeeRepo.findAll()).thenReturn(List.of(employee));
        List<Employee> list = service.allEmployee();
        assertEquals(1, list.size());
    }

    @Test
    void testGetEmployeeById_Found() {
        when(employeeRepo.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> result = service.getEmployeeById(1L);
        assertTrue(result.isPresent());
        assertEquals("john@example.com", result.get().getEmail());
    }

    @Test
    void testDeleteEmployeeById() {
        when(employeeRepo.findById(1L)).thenReturn(Optional.of(employee));
        doNothing().when(employeeRepo).deleteById(1L);

        Optional<Employee> deleted = service.deleteEmployeeById(1L);
        assertTrue(deleted.isPresent());
    }

    @Test
    void testDeleteAllEmployee() {
        when(employeeRepo.findAll()).thenReturn(List.of(employee));
        doNothing().when(employeeRepo).delete(employee);

        List<Employee> list = service.deleteAllEmployee(employee);
        assertEquals(1, list.size());
    }

    @Test
    void testUpdate_EmployeeExists() {
        when(employeeRepo.existsById(1L)).thenReturn(true);
        when(employeeRepo.save(employee)).thenReturn(employee);

        Employee updated = service.update(1L, employee);
        assertEquals(1L, updated.getId());
    }

    @Test
    void testUpdate_EmployeeNotFound() {
        when(employeeRepo.existsById(1L)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> service.update(1L, employee));
    }
}

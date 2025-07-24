package com.employee.newproject.controller;

import com.employee.newproject.model.Employee;
import com.employee.newproject.repo.EmployeeRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    @BeforeEach
    void setup() {
        employeeRepo.deleteAll();
        employeeRepo.flush();
    }




    @Test
    void testAddEmployee() throws Exception {
        Employee employee = new Employee(null, "John Doe", 60000L, "john@example.com", "HR", LocalDate.of(2022, 1, 1));

        mockMvc.perform(post("/api/emp/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    void testAllEmployees() throws Exception {
        employeeRepo.save(
                new Employee(null, "Alice", 75000L, "alice@example.com", "Finance", LocalDate.of(2021, 6, 15))
        );

        mockMvc.perform(get("/api/emp/allEmployee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }
    @Test
    void testGetEmployeeById() throws Exception {
        Employee saved = employeeRepo.save(new Employee(null, "Bob", 70000L, "bob@example.com", "IT", LocalDate.of(2020, 5, 20)));

        mockMvc.perform(get("/api/emp/getEmployeeById/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("bob@example.com"))
                .andExpect(jsonPath("$.name").value("Bob"));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        Employee saved = employeeRepo.save(new Employee(null, "Samuel", 50000L, "sam@example.com", "Sales", LocalDate.of(2019, 2, 28)));
        saved.setName("Samuel Updated");

        mockMvc.perform(put("/api/emp/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Samuel Updated"));
    }

    @Test
    void testDeleteEmployeeById() throws Exception {
        Employee saved = employeeRepo.save(new Employee(null, "Temp", 40000L, "temp@example.com", "Support", LocalDate.of(2021, 8, 10)));

        mockMvc.perform(delete("/api/emp/deleteEmployeeById/" + saved.getId()))
                .andExpect(status().isOk());
    }
}
package com.employee.newproject.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "employee",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id ;
    @NotBlank
    private  String name;
    @Positive
    private  Long salary;
    @Email
    @NotBlank
    private String email;

    private  String department;

    @PastOrPresent
    private LocalDate joiningDate;

}




package com.employee.newproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI employeeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management API")
                        .description("Spring Boot REST API for managing employees")
                        .version("1.0.0"));
    }
}
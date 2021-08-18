package com.example.institutocursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class InstitutoCursosApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstitutoCursosApplication.class, args);
    }

}

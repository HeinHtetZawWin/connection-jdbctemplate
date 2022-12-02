package com.example.connectionjdbctemplate;

import com.example.connectionjdbctemplate.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class ConnectionJdbctemplateApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    public ConnectionJdbctemplateApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConnectionJdbctemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.deleteAll();
        try {
            employeeService.createEmployeeWithTransaction();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + "::has been caught.");
        }
        employeeService.listAllEmployee()
                .forEach(System.out::println);
    }
}

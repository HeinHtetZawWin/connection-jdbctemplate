package com.example.connectionjdbctemplate.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
}
